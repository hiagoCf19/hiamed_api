package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.exceptions.ValidationException;
import med.hia.api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivePatientValidate implements ValidateConsultationScheduler {
    @Autowired
    private PatientService patientService;
    public void validate(ConsultationSchedulerDTO data){
      if(data.idMedico() == null){
          return;
      }
      var patientIsActive= patientService.patientActiveById(data.idMedico());
      if(!patientIsActive){
          throw new ValidationException("O paciente não está ativo no sistema!");
      }
    }
}
