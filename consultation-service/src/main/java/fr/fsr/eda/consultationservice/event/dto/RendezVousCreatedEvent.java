package fr.fsr.eda.consultationservice.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVousCreatedEvent {
    private String eventId;
    private String rendezVousId;
    private String patientId;
    private String medecinId;
    private LocalDateTime dateRendezVous;
    private String status;
}
