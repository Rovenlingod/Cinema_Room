package cinema.repositories;

import cinema.domain.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, UUID> {
}
