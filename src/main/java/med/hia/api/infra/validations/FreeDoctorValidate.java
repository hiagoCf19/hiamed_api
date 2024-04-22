package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.exceptions.ValidationException;
import med.hia.api.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FreeDoctorValidate implements ValidateConsultationScheduler {
    @Autowired
    private ConsultationService consultationService;
    public void validate(ConsultationSchedulerDTO data){
        var isBusy=  consultationService.checkAvailableTimes(data.idMedico(), data.data());
        if(isBusy){
            throw new ValidationException("O médico já possui uma consulta marcada para este horário!");
        }
    }
}
