package med.hia.api.dto.consultation;

import jakarta.validation.constraints.NotNull;

public record ConsultationCancelDTO(
        @NotNull
        Long idConsulta,

        @NotNull
         ReasonForCancellationEnum motivoDoCancelamento
) {
}
