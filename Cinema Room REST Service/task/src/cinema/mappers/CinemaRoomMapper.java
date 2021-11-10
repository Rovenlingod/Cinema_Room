package cinema.mappers;

import cinema.domain.CinemaRoom;
import cinema.dtos.CinemaRoomCreationResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CinemaRoomMapper {

    CinemaRoomMapper INSTANCE = Mappers.getMapper(CinemaRoomMapper.class);

    @Mapping(target = "accessToken", expression = "java(cinemaRoom.getId().toString())")
    CinemaRoomCreationResponseDTO cinemaRoomToCinemaRoomCreationResponseDTO(CinemaRoom cinemaRoom);
}
