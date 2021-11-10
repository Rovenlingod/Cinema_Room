package cinema.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "seat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @Column(name = "seat_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "seat_row")
    private int seatRow;

    @Column(name = "seat_column")
    private int seatColumn;

    @Column(name = "price")
    private int price;

    @Column(name = "purchased")
    private boolean purchased;

    @Column(name = "token")
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID token = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_room_id")
    @JsonIgnore
    private CinemaRoom cinemaRoom;
}
