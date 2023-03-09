package agenda.apraespi.api.controller;

import agenda.apraespi.api.paciente.DadosCadastroPaciente;
import agenda.apraespi.api.paciente.DadosListagemPaciente;
import agenda.apraespi.api.paciente.Paciente;
import agenda.apraespi.api.paciente.PacienteRepository;
import agenda.apraespi.api.paciente.DadosAtualizacaoPaciente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("pacientes")
@RestController
public class PacientesController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente){
        pacienteRepository.save(new Paciente(dadosCadastroPaciente));
    }
//    @GetMapping
//    public Page<DadosListagemPaciente> listar(@PageableDefault(page =0, size = 10, sort = {"nome"})Pageable paginacao){
//        return pacienteRepository.findAll(paginacao).map(DadosListagemPaciente::new);
//    }
    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = { "nome" }) Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
       var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.inativar();
    }
}
