package fr.fsr.eda.consultationservice.web;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto {
    private LocalDateTime dateConsultation;
    private String rapport;
    private String rendezVousId;
    private String medecinId;
    private String patientId;
}
