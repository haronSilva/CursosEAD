package br.com.letscode.cursosead.controller;

import br.com.letscode.cursosead.model.Curso;
import br.com.letscode.cursosead.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity salvar(@Valid @RequestBody Curso curso){
        this.cursoService.salvarCurso(curso);

        ResponseEntity response = new ResponseEntity("Curso criado com sucesso",HttpStatus.CREATED);
        return response;
    }

    @GetMapping
    public List<Curso> selecionarTodos(){
        return this.cursoService.selecionarTodos();
    }

    @PutMapping("{id}")
    public void atualizarCurso(@PathVariable("id") Integer idCurso, @RequestBody Curso curso){
        this.cursoService.alterarCurso(idCurso, curso);

    }

    @DeleteMapping("{id}")
    public void deleteCurso(@PathVariable("id") Integer idCurso){
       this.cursoService.deletarCurso(idCurso);
    }



}
