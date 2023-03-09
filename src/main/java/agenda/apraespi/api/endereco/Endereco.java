package agenda.apraespi.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.cep = endereco.cep();
        this.complemento = endereco.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        if(dadosEndereco.logradouro()!= null){
            this.logradouro = dadosEndereco.logradouro();
        }
        if(dadosEndereco.bairro()!= null){
            this.bairro = dadosEndereco.bairro();
        }
        if(dadosEndereco.cidade()!= null){
            this.cidade = dadosEndereco.cidade();
        }
        if(dadosEndereco.uf()!= null){
            this.uf = dadosEndereco.uf();
        }
        if(dadosEndereco.cep()!= null){
            this.cep = dadosEndereco.cep();
        }
        if(dadosEndereco.complemento()!= null){
            this.complemento = dadosEndereco.complemento();
        }
    }
}
