package ma.fsr.eda.billingservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "factures")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String consultationId;
    private String patientId;
    private Double montant;
    private String statut; // CREATED, FAILED
    private LocalDateTime dateCreation;
}

