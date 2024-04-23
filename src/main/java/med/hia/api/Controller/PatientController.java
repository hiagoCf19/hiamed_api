package med.hia.api.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.hia.api.dto.Patient.DataPatientDTO;
import med.hia.api.dto.Patient.PatientPublicData;
import med.hia.api.dto.Patient.PatientResponseDTO;
import med.hia.api.dto.Patient.PatientUpdateDataDTO;
import med.hia.api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
@SecurityRequirement(name= "bearer-key")
public class PatientController {
    @Autowired
   private PatientService patientService;

    @PostMapping
    @Transactional
    public ResponseEntity registerPatient(@RequestBody @Valid DataPatientDTO data, UriComponentsBuilder uriComponentsBuilder){
        var patient= patientService.registerPatient(data);
        var uri= uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientResponseDTO(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientPublicData>> getAllPatients(Pageable pagination){
       var page= patientService.getAllPatients(pagination);
       return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientDetails(@PathVariable Long id){
        var patient= patientService.getPatientById(id);
        return ResponseEntity.ok(new PatientResponseDTO(patient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid PatientUpdateDataDTO data){
       var patient=  patientService.updateDataPatient(data);
       return ResponseEntity.ok(new PatientResponseDTO(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity logicalDeletePatient(@PathVariable Long id){
        patientService.logicalDeletPatient(id);
        return ResponseEntity.noContent().build();
    }

}

