package med.hia.api.dto.consultation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.hia.api.model.Consultation;

import java.time.LocalDateTime;

public record ConsultationDetailsDTO(
        Long id,
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime data
) {


        public ConsultationDetailsDTO(Consultation consulta) {
                this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
        }
}
