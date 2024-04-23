package med.hia.api.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.hia.api.dto.Doctor.DataDoctorDTO;
import med.hia.api.dto.Doctor.DoctorPublicDataDTO;
import med.hia.api.dto.Doctor.DoctorResponseDTO;
import med.hia.api.dto.Doctor.DoctorUpdateDataDTO;

import med.hia.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medico")
@SecurityRequirement(name= "bearer-key")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @Transactional
    public ResponseEntity registerDoctor(@RequestBody DataDoctorDTO data, UriComponentsBuilder uriComponentsBuilder){
        var doctor= doctorService.registerDoctor(data);
        var uri= uriComponentsBuilder.path("/medico/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorResponseDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorPublicDataDTO>> getAllDoctors(Pageable pagination){
        var page= doctorService.getAllDoctors(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDoctorDetails(@PathVariable Long id){
        var doctor= doctorService.getDoctorById(id);
        return ResponseEntity.ok(new DoctorResponseDTO(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDataDoctor(@RequestBody @Valid  DoctorUpdateDataDTO data){
        var doctor = doctorService.updateDataDoctor(data);
        return ResponseEntity.ok(new DoctorResponseDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeletDoctor(@PathVariable Long id){
        doctorService.logicalDeletDoctor(id);
        return ResponseEntity.noContent().build();
    }

}
