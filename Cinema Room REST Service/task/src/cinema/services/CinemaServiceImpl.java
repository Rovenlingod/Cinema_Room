package cinema.services;

import cinema.domain.CinemaRoom;
import cinema.domain.Seat;
import cinema.dtos.*;
import cinema.exceptions.InvalidPurchaseException;
import cinema.exceptions.NoSuchRoomException;
import cinema.mappers.CinemaRoomMapper;
import cinema.mappers.SeatMapper;
import cinema.repositories.CinemaRoomRepository;
import cinema.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CinemaServiceImpl implements CinemaService {

    private CinemaRoomRepository cinemaRoomRepository;
    private SeatRepository seatRepository;

    public CinemaServiceImpl(CinemaRoomRepository cinemaRoomRepository, SeatRepository seatRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public PurchaseResponseDTO purchase(PurchaseRequestDTO purchaseRequestDTO) {
        Optional<Seat> optSeat = seatRepository.findBySeatRowAndSeatColumn(purchaseRequestDTO.getRow(), purchaseRequestDTO.getColumn());
        Seat seat = optSeat.orElseThrow(() -> new InvalidPurchaseException("There is no seat with provided parameters"));
        if (!seat.isPurchased()) {
            seat.setPurchased(true);
            seatRepository.save(seat);
            return SeatMapper.INSTANCE.seatToPurchaseResponseDTO(seat);
        } else {
            throw new InvalidPurchaseException("The ticket has been already purchased!");
        }
    }

    @Override
    public CinemaRoomCreationResponseDTO createTestRoom() {
        CinemaRoom testRoom = new CinemaRoom();
        testRoom.setTotalRows(9);
        testRoom.setTotalColumns(9);
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Seat seat = new Seat();
                int price = 8;
                if (i < 4) {
                    price = 10;
                }
                seat.setPrice(price);
                seat.setSeatRow(i + 1);
                seat.setSeatColumn(j + 1);
                seat.setCinemaRoom(testRoom);
                seat.setPurchased(false);
                seat.setToken(UUID.randomUUID());
                seats.add(seat);
            }
        }
        testRoom.setAvailableSeats(seats);
        return CinemaRoomMapper.INSTANCE.cinemaRoomToCinemaRoomCreationResponseDTO(cinemaRoomRepository.save(testRoom));
    }

    @Override
    public CinemaRoom getCinemaRoom(String accessToken) {
        Optional<CinemaRoom> result = cinemaRoomRepository.findById(UUID.fromString(accessToken));
        return result.orElseThrow(NoSuchRoomException::new);
    }

    @Override
    public RefundResponseDTO refund(RefundRequestDTO refundRequestDTO) {
        Optional<Seat> optSeat = seatRepository.findByToken(UUID.fromString(refundRequestDTO.getToken()));
        Seat seat = optSeat.orElseThrow(() -> new InvalidPurchaseException("There is no seat with provided parameters"));
        if (seat.isPurchased()) {
            seat.setPurchased(false);
            seat.setToken(UUID.randomUUID());
            seatRepository.save(seat);
            return SeatMapper.INSTANCE.seatToRefundResponseDTO(seat);
        } else {
            throw new InvalidPurchaseException("Seat with provided token, cannot be refunded due to not being purchased");
        }
    }

    @Override
    public StatsDTO formStats() {
        StatsDTO statsDTO = new StatsDTO();
        Optional<List<Seat>> purchasedSeatsOpt = seatRepository.findByPurchased(true);
        List<Seat> purchasedSeats = purchasedSeatsOpt.orElse(Collections.emptyList());
        statsDTO.setNumberOfPurchasedTickets(purchasedSeats.size());
        statsDTO.setNumberOfAvailableSeats((int) (seatRepository.count() - purchasedSeats.size()));
        statsDTO.setCurrentIncome(purchasedSeats.stream().reduce(0, (x, y) -> x + y.getPrice(), Integer::sum));
        return statsDTO;
    }

}
