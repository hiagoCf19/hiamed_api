package med.hia.api.dto.Doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.hia.api.dto.Adress.AdressDTO;

public record DataDoctorDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        SpecialtyEnum especialidade,

        @NotNull @Valid AdressDTO endereco
) { }
