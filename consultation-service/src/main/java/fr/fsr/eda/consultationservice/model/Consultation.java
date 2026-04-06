package fr.fsr.eda.consultationservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultations")
@Data
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String rendezVousId;
    private String patientId;
    private String medecinId;
    private LocalDateTime dateConsultation;
    private String statut; // CREATED, COMPLETED
}
