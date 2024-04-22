package med.hia.api.repository;

import med.hia.api.model.Doctor;
import med.hia.api.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findAllByAtivoTrue(Pageable pagination);
    @Query("select p.ativo from Patient p where p.id = :id")
    Boolean activeTrueById(Long id);

}
