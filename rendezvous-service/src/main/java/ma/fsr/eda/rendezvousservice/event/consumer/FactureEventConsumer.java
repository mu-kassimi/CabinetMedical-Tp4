package ma.fsr.eda.rendezvousservice.event.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fsr.eda.rendezvousservice.event.dto.FactureFailedEvent;
import ma.fsr.eda.rendezvousservice.model.RendezVous;
import ma.fsr.eda.rendezvousservice.model.StatutRdv;
import ma.fsr.eda.rendezvousservice.repository.RendezVousRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class FactureEventConsumer {

    private final RendezVousRepository repository;

    @KafkaListener(topics = "facture.failed", groupId = "rendezvous-group")
    public void consumeFactureFailed(FactureFailedEvent event) {
        log.info("FactureFailedEvent reçu pour la consultationId: {}", event.getConsultationId());

        // Note: Selon l'énoncé, le rendezvous-service doit annuler le rendez-vous.
        // Si consultationId == rendezVousId dans votre base ou si id est de type Long, on tente de le parser:
        try {
            Long rdvId = Long.valueOf(event.getConsultationId());
            Optional<RendezVous> rdvOpt = repository.findById(rdvId);
            if (rdvOpt.isPresent()) {
                RendezVous rdv = rdvOpt.get();
                rdv.setStatut(StatutRdv.ANNULE);
                repository.save(rdv);
                log.info("Rendez-vous {} annulé suite à l'échec de la facturation.", rdvId);
            } else {
                log.warn("Rendez-vous {} introuvable pour annulation.", rdvId);
            }
        } catch (NumberFormatException e) {
            log.warn("Impossible de convertir consultationId '{}' en Long. Vérifiez le mapping Consultation <-> RendezVous.", event.getConsultationId());
        }
    }
}

