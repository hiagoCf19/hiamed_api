package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;


@Component
public class ValidateOpeningHours implements ValidateConsultationScheduler {
    public void validate(ConsultationSchedulerDTO data){
    var timeAndDate= data.data();
    var sunday= timeAndDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    var beforeOpening= timeAndDate.getHour() < 7;
    var afterClosing= timeAndDate.getHour() > 18;
    if(sunday || beforeOpening || afterClosing){
        throw new ValidationException("Impossível marcar uma consulta fora do horairo de funcionamento da clínica");
    }
    }
}
