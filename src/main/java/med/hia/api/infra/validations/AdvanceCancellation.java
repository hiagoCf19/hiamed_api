package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationCancelDTO;
import med.hia.api.infra.exceptions.ValidationException;
import med.hia.api.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AdvanceCancellation implements ValidateConsultationCancel {
    @Autowired
    private ConsultationService consultationService;
    @Override
    public void validate(ConsultationCancelDTO data) {
        var consulta= consultationService.getConsultationtById(data.idConsulta());
        var now= LocalDateTime.now();
        var differenceInHours= Duration.between(now, consulta.getData()).toHours();
        if(differenceInHours < 24){
            throw new ValidationException("Erro! A consulta só pode ser cancelada com antecedência mínima de 24 horas!");
        }
    }
}
