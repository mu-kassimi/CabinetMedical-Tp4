package ma.fsr.eda.billingservice.event.dto;

import lombok.*;
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

