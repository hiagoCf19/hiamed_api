package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationCancelDTO;
import med.hia.api.dto.consultation.ConsultationSchedulerDTO;

public interface ValidateConsultationCancel {
    void validate(ConsultationCancelDTO data);
}
