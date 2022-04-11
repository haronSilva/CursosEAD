package br.com.letscode.cursosead.service;

import br.com.letscode.cursosead.exception.CursoNaoEncontradoException;
import br.com.letscode.cursosead.model.Curso;
import br.com.letscode.cursosead.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    public Curso selecionarCurso (Integer id){
        return this.cursoRepository.findById(id).orElseThrow(CursoNaoEncontradoException::new);
    }

    public List<Curso> selecionarTodos(){
        return this.cursoRepository.findAll();
    }

    public void salvarCurso(Curso curso){
        this.cursoRepository.save(curso);
    }

    public void alterarCurso(Integer id, Curso cursoRequest){
        Curso curso = this.selecionarCurso(id);
        curso.setNome(cursoRequest.getNome());
        this.salvarCurso(curso);
    }

    public void deletarCurso(Integer id){
        Curso curso = selecionarCurso(id);
        this.cursoRepository.delete(curso);
    }
}
