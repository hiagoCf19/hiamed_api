package med.hia.api.infra.validations;

import med.hia.api.dto.consultation.ConsultationSchedulerDTO;

public interface ValidateConsultationScheduler {
    void validate(ConsultationSchedulerDTO data);
}
