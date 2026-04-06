package fr.fsr.eda.consultationservice.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RendezVousCreatedEvent {
    private String eventId;
    private String rendezVousId;
    private String patientId;
    private String medecinId;
    private LocalDateTime dateRendezVous;
    private String status;
}
