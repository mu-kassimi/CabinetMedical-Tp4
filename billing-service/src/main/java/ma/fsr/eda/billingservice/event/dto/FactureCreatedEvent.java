package ma.fsr.eda.billingservice.event.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactureCreatedEvent {
    private String eventId;
    private String factureId;
    private String consultationId;
    private String patientId;
    private Double montant;
    private String statut;
    private LocalDateTime dateCreation;
}

