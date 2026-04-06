package fr.fsr.eda.consultationservice.event.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ConsultationCreatedEvent {
    private String eventId;
    private String consultationId;
    private String rendezVousId;
    private String patientId;
    private String medecinId;
    private LocalDateTime dateConsultation;
    private String statut;
}
