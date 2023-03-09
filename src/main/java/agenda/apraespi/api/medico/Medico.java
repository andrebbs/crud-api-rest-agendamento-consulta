package agenda.apraespi.api.medico;

import agenda.apraespi.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(AtualizaCadastroMedico atualizaCadastroMedico) {
       if (atualizaCadastroMedico.nome() != null) {
           this.nome = atualizaCadastroMedico.nome();
       }
       if (atualizaCadastroMedico.telefone() != null){
       this.telefone = atualizaCadastroMedico.telefone();
       }
       if (atualizaCadastroMedico.endereco() != null)
        this.endereco.atualizarInformacoes(atualizaCadastroMedico.endereco());
    }

    public void desabilitar() {
        this.ativo = false;
    }
}
