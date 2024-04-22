package med.hia.api.dto.consultation;

import med.hia.api.dto.Doctor.SpecialtyEnum;

public record ConsultationDoctorDTO(String nome, String crm, SpecialtyEnum especialidade) {
}
