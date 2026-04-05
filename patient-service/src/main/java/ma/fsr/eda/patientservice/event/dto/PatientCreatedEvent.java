package ma.fsr.eda.patientservice.event.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@AllArgsConstructor
@Data
public class PatientCreatedEvent {
    private String eventId;
    private Long patientId;
    private String nom;
    private String telephone;
    private String genre;
    private LocalDateTime dateCreation;
}
