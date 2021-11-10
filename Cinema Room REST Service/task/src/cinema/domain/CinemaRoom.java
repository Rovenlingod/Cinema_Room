package cinema.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cinema_room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaRoom {

    @Id
    @Column(name = "cinema_room_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonProperty("total_rows")
    @Column(name = "total_rows")
    private int totalRows;

    @JsonProperty("total_columns")
    @Column(name = "total_columns")
    private int totalColumns;

    @JsonProperty("available_seats")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    private List<Seat> availableSeats;

}
