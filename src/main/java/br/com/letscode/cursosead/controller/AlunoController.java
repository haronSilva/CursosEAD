package br.com.letscode.cursosead.controller;

import br.com.letscode.cursosead.exception.AlunoCadastradoException;
import br.com.letscode.cursosead.exception.AlunoNaoEncontradoException;
import br.com.letscode.cursosead.model.Aluno;
import br.com.letscode.cursosead.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping("{matricula}")
    public ResponseEntity selecionarAlunoByMatricula(@PathVariable("matricula") String matricula){
        Aluno aluno = this.alunoService.selecionaAlunoByMatricula(matricula);
        ResponseEntity response = new ResponseEntity(aluno, HttpStatus.OK);
        return response;
    }

    @PostMapping
    public ResponseEntity salvarAluno(@Valid @RequestBody Aluno aluno){
        this.alunoService.salvarAluno(aluno);
        ResponseEntity response = new ResponseEntity("Aluno criado com sucesso", HttpStatus.CREATED);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarAlunoNaoEncontrado(AlunoNaoEncontradoException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarAlunoDuplicado(AlunoCadastradoException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        return response;
    }
}
