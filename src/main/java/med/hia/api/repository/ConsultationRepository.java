package med.hia.api.repository;

import med.hia.api.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
Boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime date);

}
