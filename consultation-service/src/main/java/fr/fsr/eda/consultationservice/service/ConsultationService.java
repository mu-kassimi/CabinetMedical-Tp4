package fr.fsr.eda.consultationservice.service;

import fr.fsr.eda.consultationservice.event.dto.RendezVousCreatedEvent;
import fr.fsr.eda.consultationservice.event.producer.ConsultationEventProducer;
import fr.fsr.eda.consultationservice.model.Consultation;
import fr.fsr.eda.consultationservice.repository.ConsultationRepository;
import fr.fsr.eda.consultationservice.web.ConsultationDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationService {
    private final ConsultationRepository repository;
    private final ConsultationEventProducer eventProducer;

    @Transactional
    public void createConsultationFromRdv(RendezVousCreatedEvent event) {
        Consultation consultation = new Consultation();
        consultation.setRendezVousId(event.getRendezVousId());
        consultation.setPatientId(event.getPatientId());
        consultation.setMedecinId(event.getMedecinId());
        consultation.setDateConsultation(LocalDateTime.now());
        consultation.setStatut("CREATED");
        Consultation saved = repository.save(consultation);
        eventProducer.publishConsultationCreated(saved);
    }

    public List<Consultation> getAll() {
        return repository.findAll();
    }

    public List<Consultation> getAllConsultations() {
        return repository.findAll();
    }

    public Consultation getConsultationById(String id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Consultation introuvable : id = " + id));
    }

    public Consultation createConsultation(ConsultationDto consultationDto) {
        Consultation consultation = new Consultation();
        consultation.setRendezVousId(consultationDto.getRendezVousId());
        consultation.setPatientId(consultationDto.getPatientId());
        consultation.setMedecinId(consultationDto.getMedecinId());
        consultation.setDateConsultation(consultationDto.getDateConsultation());
        return repository.save(consultation);
    }

    public Consultation updateConsultation(String id, ConsultationDto consultationDto) throws Exception {
        Consultation consultation = getConsultationById(id);
        consultation.setRendezVousId(consultationDto.getRendezVousId());
        consultation.setPatientId(consultationDto.getPatientId());
        consultation.setMedecinId(consultationDto.getMedecinId());
        consultation.setDateConsultation(consultationDto.getDateConsultation());
        return repository.save(consultation);
    }

    public void deleteConsultation(String id) {
        repository.deleteById(id);
    }
}
