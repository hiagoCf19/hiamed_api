package med.hia.api.dto.consultation;


import java.time.LocalDateTime;


public record ConsultationDTO(LocalDateTime data, Long id, ConsultationDoctorDTO doctor, ConsultationPatientDTO patient) {



}
