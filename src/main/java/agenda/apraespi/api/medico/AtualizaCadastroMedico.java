package agenda.apraespi.api.medico;

import agenda.apraespi.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record AtualizaCadastroMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
