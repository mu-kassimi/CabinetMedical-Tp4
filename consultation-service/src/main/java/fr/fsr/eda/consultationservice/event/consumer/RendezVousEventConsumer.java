package fr.fsr.eda.consultationservice.event.consumer;

import fr.fsr.eda.consultationservice.event.dto.RendezVousCreatedEvent;
import fr.fsr.eda.consultationservice.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RendezVousEventConsumer {
    private final ConsultationService service;
    @KafkaListener(topics = "rendezvous.created")
    public void consume(RendezVousCreatedEvent event) {
        service.createConsultationFromRdv(event);
    }
}
