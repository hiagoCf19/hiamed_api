package med.hia.api.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.hia.api.dto.consultation.ConsultationDTO;
import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.validations.ValidateConsultationScheduler;
import med.hia.api.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name= "bearer-key")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private List<ValidateConsultationScheduler> validations;

    @PostMapping
    @Transactional
    public ResponseEntity scheduling(@RequestBody @Valid ConsultationSchedulerDTO data){
        validations.forEach(v -> v.validate(data));
        consultationService.sheduling(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<ConsultationDTO>> getConsultations(Pageable pagination){
        var page= consultationService.getAllConsults(pagination);
        return ResponseEntity.ok(page);
    }


}

