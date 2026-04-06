package fr.fsr.eda.consultationservice.repository;

import fr.fsr.eda.consultationservice.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, String> {
}
