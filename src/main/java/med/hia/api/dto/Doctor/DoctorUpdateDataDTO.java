package med.hia.api.dto.Doctor;

import jakarta.validation.constraints.NotNull;
import med.hia.api.dto.Adress.AdressDTO;

public record DoctorUpdateDataDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        AdressDTO endereco) {
}
