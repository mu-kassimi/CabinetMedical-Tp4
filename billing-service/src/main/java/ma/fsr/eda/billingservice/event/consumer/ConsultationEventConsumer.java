package ma.fsr.eda.billingservice.event.consumer;

import lombok.RequiredArgsConstructor;
import ma.fsr.eda.billingservice.event.dto.ConsultationCreatedEvent;
import ma.fsr.eda.billingservice.service.BillingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsultationEventConsumer {

    private final BillingService billingService;

    @KafkaListener(topics = "consultation.created")
    public void consume(ConsultationCreatedEvent event) {
        billingService.generateFacture(event);
    }
}

