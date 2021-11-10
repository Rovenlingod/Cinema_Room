package cinema.mappers;

import cinema.domain.Seat;
import cinema.dtos.PurchaseResponseDTO;
import cinema.dtos.RefundResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T21:14:44+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (JetBrains s.r.o.)"
)
public class SeatMapperImpl implements SeatMapper {

    @Override
    public PurchaseResponseDTO seatToPurchaseResponseDTO(Seat seat) {
        if ( seat == null ) {
            return null;
        }

        PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();

        purchaseResponseDTO.setToken( seat.getToken().toString() );
        purchaseResponseDTO.setTicket( new cinema.dtos.TicketDTO(seat.getSeatRow(), seat.getSeatColumn(), seat.getPrice()) );

        return purchaseResponseDTO;
    }

    @Override
    public RefundResponseDTO seatToRefundResponseDTO(Seat seat) {
        if ( seat == null ) {
            return null;
        }

        RefundResponseDTO refundResponseDTO = new RefundResponseDTO();

        refundResponseDTO.setTicket( new cinema.dtos.TicketDTO(seat.getSeatRow(), seat.getSeatColumn(), seat.getPrice()) );

        return refundResponseDTO;
    }
}
