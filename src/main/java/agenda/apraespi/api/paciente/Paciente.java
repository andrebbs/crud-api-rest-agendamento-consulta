package agenda.apraespi.api.paciente;

import agenda.apraespi.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Pacientes")
@Entity(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Paciente {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;
    public Paciente(DadosCadastroPaciente dadosCadastroPaciente){
        this.nome = dadosCadastroPaciente.nome();
        this.cpf = dadosCadastroPaciente.cpf();
        this.telefone = dadosCadastroPaciente.telefone();
        this.email = dadosCadastroPaciente.email();
        this.endereco = new Endereco(dadosCadastroPaciente.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
           endereco.atualizarInformacoes(dados.endereco());
        }
    }
    public void inativar() {
        this.ativo = false;
    }
}
