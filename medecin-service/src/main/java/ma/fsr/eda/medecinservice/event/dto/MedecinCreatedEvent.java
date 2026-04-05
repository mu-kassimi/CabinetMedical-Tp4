package ma.fsr.eda.medecinservice.event.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class MedecinCreatedEvent {
    private String eventId;
    private String medecinId;
    private String nom;
    private String specialite;
    private String email;
    private LocalDateTime dateCreation;
}