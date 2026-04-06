package fr.fsr.eda.consultationservice.web;

import fr.fsr.eda.consultationservice.model.Consultation;
import fr.fsr.eda.consultationservice.service.ConsultationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/api/v1/consultations")
@AllArgsConstructor
public class ConsultationController {

    private final ConsultationService consultationService;

    @GetMapping
    public List<Consultation> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable String id) throws Exception {
        return consultationService.getConsultationById(id);
    }

    @PostMapping
    public Consultation createConsultation(@RequestBody ConsultationDto consultationDto) {
        return consultationService.createConsultation(consultationDto);
    }

    @PutMapping("/{id}")
    public Consultation updateConsultation(@PathVariable String id, @RequestBody ConsultationDto consultationDto) throws Exception {
        return consultationService.updateConsultation(id, consultationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultation(@PathVariable String id) {
        consultationService.deleteConsultation(id);
    }
}
