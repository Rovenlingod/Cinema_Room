package cinema.mappers;

import cinema.domain.CinemaRoom;
import cinema.domain.Seat;
import cinema.dtos.CinemaRoomCreationResponseDTO;
import cinema.dtos.PurchaseResponseDTO;
import cinema.dtos.RefundResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SeatMapper {

    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    @Mappings({
            @Mapping(target = "token", expression = "java(seat.getToken().toString())"),
            @Mapping(target = "ticket", expression = "java(new cinema.dtos.TicketDTO(seat.getSeatRow(), seat.getSeatColumn(), seat.getPrice()))")
    })
    PurchaseResponseDTO seatToPurchaseResponseDTO(Seat seat);

    @Mapping(target = "ticket", expression = "java(new cinema.dtos.TicketDTO(seat.getSeatRow(), seat.getSeatColumn(), seat.getPrice()))")
    RefundResponseDTO seatToRefundResponseDTO(Seat seat);

}
