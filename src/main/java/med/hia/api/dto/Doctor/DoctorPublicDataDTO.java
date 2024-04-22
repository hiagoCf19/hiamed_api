package med.hia.api.dto.Doctor;

import med.hia.api.model.Doctor;



public record DoctorPublicDataDTO(Long id, String nome, String email, String crm, SpecialtyEnum especialidade) {
    public DoctorPublicDataDTO(Doctor doctor){
        this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
    }
}
