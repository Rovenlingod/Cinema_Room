package cinema.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefundResponseDTO {
    @JsonProperty("returned_ticket")
    private TicketDTO ticket;
}
