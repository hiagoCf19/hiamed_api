package med.hia.api.services;

import med.hia.api.dto.consultation.*;

import med.hia.api.infra.exceptions.ValidationException;
import med.hia.api.infra.validations.ValidateConsultationCancel;
import med.hia.api.model.Consultation;
import med.hia.api.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;


    public Boolean checkAvailableTimes(Long id, LocalDateTime date){
        return consultationRepository.existsByMedicoIdAndData(id, date);
    }
    public void sheduling(ConsultationSchedulerDTO data) {
        doctorService.verifyDoctorExistsById(data);
        patientService.verifyPatientExistsById(data);

        var doctor = doctorService.getCompleteDoctorById(data);
        var patient = patientService.getCompletePatientById(data);

        var consultation= new Consultation(null, doctor, patient , data.data(), null);


        consultationRepository.save(consultation);

    }
    public Page<ConsultationDTO> getAllConsults(@PageableDefault(size = 10) Pageable pagination){
        var consultas= consultationRepository.findAll(pagination);
         return consultas.map(c-> new ConsultationDTO(c.getData(), c.getId(), new ConsultationDoctorDTO(c.getMedico().getNome(), c.getMedico().getCrm(), c.getMedico().getEspecialidade()), new ConsultationPatientDTO(c.getPaciente().getNome(), c.getPaciente().getCpf())));
    }
    public void cancelConsultation(ConsultationCancelDTO data){
        if (!consultationRepository.existsById(data.idConsulta())) {
            throw new ValidationException("A consulta com o id: " + data.idConsulta() + " não existe no sistema!");
        }

        var consultation= consultationRepository.getReferenceById(data.idConsulta());
        consultation.cancel(data.motivoDoCancelamento());

    }
    public Consultation getConsultationtById(Long id){
        return consultationRepository.getReferenceById(id);
    }


}
