package fr.fsr.eda.consultationservice.event.producer;

import fr.fsr.eda.consultationservice.event.dto.ConsultationCreatedEvent;
import fr.fsr.eda.consultationservice.model.Consultation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ConsultationEventProducer {
    private final KafkaTemplate<String, ConsultationCreatedEvent> kafkaTemplate;
    public void publishConsultationCreated(Consultation consultation) {
        ConsultationCreatedEvent event = new ConsultationCreatedEvent(
                UUID.randomUUID().toString(),
                consultation.getId(),
                consultation.getRendezVousId(),
                consultation.getPatientId(),
                consultation.getMedecinId(),
                consultation.getDateConsultation(),
                consultation.getStatut()
        );
        kafkaTemplate.send("consultation.created", consultation.getId(), event);
    }
}
