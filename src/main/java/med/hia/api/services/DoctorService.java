package med.hia.api.services;

import med.hia.api.dto.Doctor.DataDoctorDTO;
import med.hia.api.dto.Doctor.DoctorPublicDataDTO;
import med.hia.api.dto.Doctor.DoctorUpdateDataDTO;
import med.hia.api.dto.consultation.ConsultationSchedulerDTO;
import med.hia.api.infra.exceptions.ValidationException;
import med.hia.api.model.Doctor;
import med.hia.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getDoctorById(Long id){
        return doctorRepository.getReferenceById(id);
    }
    public Doctor registerDoctor(DataDoctorDTO data){
        return doctorRepository.save(new Doctor(data));
    }

    public Page<DoctorPublicDataDTO> getAllDoctors(@PageableDefault(size = 10, sort ={"nome"}) Pageable pagination){
        return doctorRepository.findAllByAtivoTrue(pagination).map(DoctorPublicDataDTO::new);
    }

    public Doctor updateDataDoctor(DoctorUpdateDataDTO data){
       var doctor= getDoctorById(data.id());
        doctor.updateData(data);
        return doctor;
    }

    public void logicalDeletDoctor(Long id){
        var doctor= getDoctorById(id);
        doctor.logicalDelete();

    }
    public Doctor getCompleteDoctorById(ConsultationSchedulerDTO data){
        if(data.idMedico() != null){
            return doctorRepository.getReferenceById(data.idMedico());
        }
        if(data.especialidade() == null){
            throw new ValidationException("A especialidade é obrigatória quando o médico não foi escolhido");
        }
    return doctorRepository.chooseRandomAvailableDoctorAtDate(data.especialidade(), data.data());
    }

    public void verifyDoctorExistsById(ConsultationSchedulerDTO data){
        if(data.idMedico() != null && !doctorRepository.existsById(data.idMedico())){
            throw new ValidationException("Não consta no sistema um médico com o id: " + data.idMedico() + "!" );
        }
    }
    public Boolean doctorActiveById(Long id){
        return  doctorRepository.activeTrueById(id);
    }






}