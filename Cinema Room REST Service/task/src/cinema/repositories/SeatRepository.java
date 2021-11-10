package cinema.repositories;

import cinema.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
    Optional<Seat> findBySeatRowAndSeatColumn(int seatRow, int seatColumn);
    Optional<Seat> findByToken(UUID token);
    Optional<List<Seat>> findByPurchased(boolean purchased);
}
