package ma.fsr.eda.billingservice.event.dto;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultationCreatedEvent {
    private String eventId;
    private String consultationId;
    private String rendezVousId;
    private String patientId;
    private String medecinId;
    private LocalDateTime dateConsultation;
    private String statut;
}
