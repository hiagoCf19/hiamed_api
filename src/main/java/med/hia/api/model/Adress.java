package med.hia.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.hia.api.dto.Adress.AdressDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Adress(AdressDTO adress) {
        this.logradouro = adress.logradouro();
        this.bairro = adress.bairro();
        this.cep = adress.cep();
        this.uf = adress.uf();
        this.cidade = adress.cidade();
        this.numero = adress.numero();
        this.complemento = adress.complemento();
    }

    public void updateDataAdress(AdressDTO data) {
        if (data.logradouro() != null) {
            this.logradouro = data.logradouro();
        }
        if (data.bairro() != null) {
            this.bairro = data.bairro();
        }
        if (data.cep() != null) {
            this.cep = data.cep();
        }
        if (data.uf() != null) {
            this.uf = data.uf();
        }
        if (data.cidade() != null) {
            this.cidade = data.cidade();
        }
        if (data.numero() != null) {
            this.numero = data.numero();
        }
        if (data.complemento() != null) {
            this.complemento = data.complemento();
        }
    }
}
