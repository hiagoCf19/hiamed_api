package med.hia.api.dto.consultation;

import med.hia.api.model.Consultation;
import med.hia.api.model.Patient;

public record ConsultationPatientDetailsDTO (String Nome,
                                             String Cpf,
                                             String Telefone,
                                             String Email) {
    public  ConsultationPatientDetailsDTO(Consultation consultation){
        this(consultation.getPaciente().getNome(), consultation.getPaciente().getCpf(), consultation.getPaciente().getTelefone(), consultation.getPaciente().getEmail() );

    }


}
