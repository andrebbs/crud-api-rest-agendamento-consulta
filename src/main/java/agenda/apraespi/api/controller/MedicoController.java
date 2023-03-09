package agenda.apraespi.api.controller;

import agenda.apraespi.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("medicos")
@RestController
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados));
    }

//    @GetMapping
//    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
//        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
//    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaCadastroMedico atualizaCadastroMedico){
        var medico = medicoRepository.getReferenceById(atualizaCadastroMedico.id());
        medico.atualizarInformacoes(atualizaCadastroMedico);
    }
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id){
//        medicoRepository.deleteById(id);
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desabilitar(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.desabilitar();
    }
}