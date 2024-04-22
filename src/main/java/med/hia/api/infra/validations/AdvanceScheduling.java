package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AdvanceScheduling implements ValidateConsultationScheduler {
    public void validate(ConsultationSchedulerDTO data){
        var timeAndDate= data.data();
        var now= LocalDateTime.now();
        var differenceInMinutes= Duration.between(now, timeAndDate).toMinutes();
         if(differenceInMinutes < 30 ){
             throw new ValidationException("A consulta deve ser agendada com no mínimo 30 minutos de antecedência");
         }
    }
}
