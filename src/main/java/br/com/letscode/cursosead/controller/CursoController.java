package br.com.letscode.cursosead.controller;

import br.com.letscode.cursosead.model.Curso;
import br.com.letscode.cursosead.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public  void salvar(@RequestBody Curso curso){
        this.cursoRepository.save(curso);
    }
}
