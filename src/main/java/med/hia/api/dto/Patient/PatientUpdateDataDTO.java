package med.hia.api.dto.Patient;

import jakarta.validation.constraints.NotNull;
import med.hia.api.dto.Adress.AdressDTO;

public record PatientUpdateDataDTO(
        @NotNull Long id,
        String nome,
        String telefone,
        AdressDTO endereco) {
}
