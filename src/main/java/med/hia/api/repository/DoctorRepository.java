package med.hia.api.repository;
import med.hia.api.dto.Doctor.SpecialtyEnum;
import med.hia.api.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findAllByAtivoTrue(Pageable pagination);

    @Query("""
            select m from medicos m
            where
            m.ativo = true 
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c
                where
                c.data = :data
               
            )
            order by rand()
            limit 1
        """)
    Doctor chooseRandomAvailableDoctorAtDate(SpecialtyEnum especialidade, LocalDateTime data);

    @Query("select m.ativo from medicos m where m.id = :id")
    Boolean activeTrueById(Long id);
}
