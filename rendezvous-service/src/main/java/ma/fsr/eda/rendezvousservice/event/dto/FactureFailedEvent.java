package ma.fsr.eda.rendezvousservice.event.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactureFailedEvent {
    private String eventId;
    private String consultationId;
    private String reason;
    private LocalDateTime dateFailure;
}

