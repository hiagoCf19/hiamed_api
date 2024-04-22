package med.hia.api.dto.consultation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.hia.api.dto.Doctor.SpecialtyEnum;

import java.time.LocalDateTime;

public record ConsultationSchedulerDTO(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime data,
        SpecialtyEnum especialidade
){}
