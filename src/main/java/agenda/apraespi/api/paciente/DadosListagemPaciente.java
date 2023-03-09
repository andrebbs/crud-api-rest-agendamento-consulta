package agenda.apraespi.api.paciente;

public record DadosListagemPaciente (
    Long Id,
    String Nome,
    String email,
    String cpf
)
{
    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}
