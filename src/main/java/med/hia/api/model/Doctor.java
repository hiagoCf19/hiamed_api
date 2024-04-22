package med.hia.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.hia.api.dto.Doctor.DataDoctorDTO;
import med.hia.api.dto.Doctor.DoctorUpdateDataDTO;
import med.hia.api.dto.Doctor.SpecialtyEnum;

@Entity(name= "medicos")
@Table(name= "medicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private SpecialtyEnum especialidade;
    @Embedded
    private Adress endereco;

    public Doctor(DataDoctorDTO data) {
        this.ativo= true;
        this.nome = data.nome();
        this.email = data.email();
        this.telefone= data.telefone();
        this.crm = data.crm();
        this.especialidade = data.especialidade();
        this.endereco= new Adress(data.endereco());
    }

    public void updateData(DoctorUpdateDataDTO data){
        if(data.nome() != null){
            this.nome= data.nome();
        }
        if(data.telefone() != null){
            this.telefone= data.telefone();
        }
        if(data.endereco() != null){
            this.endereco.updateDataAdress(data.endereco());
        }
    }

    public void logicalDelete(){
        this.ativo= false;
    }

}
