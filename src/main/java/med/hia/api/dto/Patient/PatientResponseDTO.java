package med.hia.api.dto.Patient;

import med.hia.api.model.Adress;
import med.hia.api.model.Patient;

public record PatientResponseDTO(Long id, String nome, String email, String telefone, String cpf, Adress endereco) {
    public PatientResponseDTO(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone(), patient.getCpf(), patient.getEndereco());
    }
}
