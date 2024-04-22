package med.hia.api.dto.consultation;


import java.time.LocalDateTime;


public record ConsultationDTO(LocalDateTime data, ConsultationDoctorDTO doctor, ConsultationPatientDTO patient) {



}
