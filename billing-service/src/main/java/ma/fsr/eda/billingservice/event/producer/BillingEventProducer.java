package ma.fsr.eda.billingservice.event.producer;

import lombok.RequiredArgsConstructor;
import ma.fsr.eda.billingservice.event.dto.FactureCreatedEvent;
import ma.fsr.eda.billingservice.event.dto.FactureFailedEvent;
import ma.fsr.eda.billingservice.model.Facture;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BillingEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishFactureCreated(Facture facture) {
        FactureCreatedEvent event = new FactureCreatedEvent(
                UUID.randomUUID().toString(),
                facture.getId(),
                facture.getConsultationId(),
                facture.getPatientId(),
                facture.getMontant(),
                facture.getStatut(),
                facture.getDateCreation()
        );
        kafkaTemplate.send("facture.created", facture.getId(), event);
    }

    public void publishFactureFailed(String consultationId, String reason) {
        FactureFailedEvent event = new FactureFailedEvent(
                UUID.randomUUID().toString(),
                consultationId,
                reason,
                LocalDateTime.now()
        );
        kafkaTemplate.send("facture.failed", consultationId, event);
    }
}

