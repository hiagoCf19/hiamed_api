package med.hia.api.services;
import med.hia.api.dto.Patient.DataPatientDTO;
import med.hia.api.dto.Patient.PatientPublicData;
import med.hia.api.dto.Patient.PatientUpdateDataDTO;
import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.exceptions.ValidationException;
import med.hia.api.model.Patient;
import med.hia.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientById(Long id){
        return patientRepository.getReferenceById(id);
    }
    public Patient registerPatient(DataPatientDTO data){
        return  patientRepository.save(new Patient(data));
    }
    public Page<PatientPublicData> getAllPatients(@PageableDefault(size = 10, sort ={"nome"}) Pageable pagination){
        return patientRepository.findAllByAtivoTrue(pagination).map(PatientPublicData::new);
    }
    public Patient updateDataPatient(PatientUpdateDataDTO data){
        var patient= getPatientById(data.id());
         patient.updatePatient(data);
         return patient;

    }

    public void logicalDeletPatient(Long id){
        var patient= getPatientById(id);
        patient.logicalDelete();
    }

    public Patient getCompletePatientById(ConsultationSchedulerDTO data){
        return patientRepository.findById(data.idPaciente()).orElseThrow(()-> new ValidationException("Paciente com o id: " + data.idPaciente() + " não encontrado!"));
    }
    public void verifyPatientExistsById(ConsultationSchedulerDTO data){
        if(!patientRepository.existsById(data.idPaciente())){
            throw new ValidationException("Não consta no sistema um paciente com o id: " + data.idPaciente() + "!" );
        }
    }



    public Boolean patientActiveById(Long id){
        return  patientRepository.activeTrueById(id);
    }
}
