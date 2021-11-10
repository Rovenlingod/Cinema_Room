package cinema.mappers;

import cinema.domain.CinemaRoom;
import cinema.dtos.CinemaRoomCreationResponseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T20:34:02+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (JetBrains s.r.o.)"
)
public class CinemaRoomMapperImpl implements CinemaRoomMapper {

    @Override
    public CinemaRoomCreationResponseDTO cinemaRoomToCinemaRoomCreationResponseDTO(CinemaRoom cinemaRoom) {
        if ( cinemaRoom == null ) {
            return null;
        }

        CinemaRoomCreationResponseDTO cinemaRoomCreationResponseDTO = new CinemaRoomCreationResponseDTO();

        cinemaRoomCreationResponseDTO.setAccessToken( cinemaRoom.getId().toString() );

        return cinemaRoomCreationResponseDTO;
    }
}
