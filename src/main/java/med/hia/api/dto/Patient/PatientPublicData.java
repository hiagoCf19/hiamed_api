package med.hia.api.dto.Patient;

import med.hia.api.model.Patient;

public record PatientPublicData(Long id, String nome, String email, String cpf) {
public PatientPublicData(Patient patient){
    this(patient.getId(), patient.getNome(),patient.getEmail(), patient.getCpf());
}

}
