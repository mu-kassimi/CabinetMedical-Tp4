package ma.fsr.eda.billingservice.service;

import lombok.RequiredArgsConstructor;
import ma.fsr.eda.billingservice.event.dto.ConsultationCreatedEvent;
import ma.fsr.eda.billingservice.event.producer.BillingEventProducer;
import ma.fsr.eda.billingservice.model.Facture;
import ma.fsr.eda.billingservice.repository.FactureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingService {

    private final FactureRepository repository;
    private final BillingEventProducer eventProducer;

    @Transactional
    public void generateFacture(ConsultationCreatedEvent event) {
        try {
            Facture facture = new Facture();
            facture.setConsultationId(event.getConsultationId());
            facture.setPatientId(event.getPatientId());
            facture.setMontant(200.0); // Exemple montant fixe
            facture.setStatut("CREATED");
            facture.setDateCreation(LocalDateTime.now());

            Facture saved = repository.save(facture);
            eventProducer.publishFactureCreated(saved);
        } catch (Exception e) {
            eventProducer.publishFactureFailed(
                    event.getConsultationId(),
                    "Erreur génération facture"
            );
        }
    }

    public List<Facture> getAll() {
        return repository.findAll();
    }

    public Facture getById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Facture non trouvée"));
    }
}

