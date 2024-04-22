package med.hia.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.hia.api.dto.Patient.DataPatientDTO;
import med.hia.api.dto.Patient.PatientUpdateDataDTO;

@Entity
@Table(name = "pacientes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        private String nome;
        @NotNull
        private String email;
        @NotNull
        private String telefone;
        @NotNull
        private String cpf;
        @Embedded
        private Adress endereco;

        private Boolean ativo;

    public Patient(DataPatientDTO data) {
        this.ativo= true;
        this.nome= data.nome();
        this.email= data.email();
        this.telefone= data.telefone();
        this.cpf= data.cpf();
        this.endereco= new Adress(data.endereco());
    }
    public void updatePatient(PatientUpdateDataDTO data){
            if(data.nome() != null){
                this.nome= data.nome();
            }
            if (data.telefone() != null){
                this.telefone= data.telefone();
            }
            if (data.endereco() != null){
                this.endereco.updateDataAdress(data.endereco());
            }
    }
    public void logicalDelete(){
        this.ativo= false;
    }

}
