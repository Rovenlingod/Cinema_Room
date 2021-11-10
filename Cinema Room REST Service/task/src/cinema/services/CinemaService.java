package cinema.services;

import cinema.domain.CinemaRoom;
import cinema.dtos.*;

public interface CinemaService {

    PurchaseResponseDTO purchase(PurchaseRequestDTO purchaseRequestDTO);
    RefundResponseDTO refund(RefundRequestDTO refundRequestDTO);
    CinemaRoom getCinemaRoom(String accessToken);
    StatsDTO formStats();
    CinemaRoomCreationResponseDTO createTestRoom();
}
