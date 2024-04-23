package med.hia.api.dto.Doctor;

import med.hia.api.model.Adress;
import med.hia.api.model.Doctor;

public record DoctorResponseDTO (Long id, String nome, String email, String crm, String telefone, SpecialtyEnum especialidade, Adress endereco){
    public DoctorResponseDTO (Doctor medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}
