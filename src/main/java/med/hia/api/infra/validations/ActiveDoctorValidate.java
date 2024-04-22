package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.exceptions.ValidationException;
import med.hia.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveDoctorValidate implements ValidateConsultationScheduler {
    @Autowired
    private DoctorService doctorService;
    public void validate(ConsultationSchedulerDTO data){
        if(data.idMedico() == null){
            return;
        }
        var isActive= doctorService.doctorActiveById(data.idMedico());
        if(!isActive){
        throw new ValidationException("O médico não está ativo no sistema");
        }
    }
}
