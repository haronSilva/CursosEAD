package br.com.letscode.cursosead.service;

import br.com.letscode.cursosead.exception.AlunoCadastradoException;
import br.com.letscode.cursosead.exception.AlunoNaoEncontradoException;
import br.com.letscode.cursosead.model.Aluno;
import br.com.letscode.cursosead.repository.AlunoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Cacheable(value = "alunos", key="#aluno.matricula")
    public Aluno salvarAluno(Aluno aluno){
        if(!this.alunoRepository.existsByMatricula(aluno.getMatricula())){
            return this.alunoRepository.save(aluno);
        } else {
            throw new AlunoCadastradoException();
        }

    }

    @CachePut(value="alunos", key="#matricula")
    public Aluno updateAluno(String matricula, Aluno aluno){
        Aluno entidade = this.selecionaAlunoByMatricula(matricula);
        entidade.setNome(aluno.getNome());
        return this.alunoRepository.save(entidade);
    }

    @CacheEvict(value = "alunos", allEntries = true)
    public void deletarAluno(String matricula){
        Aluno entidade = this.selecionaAlunoByMatricula(matricula);
        this.alunoRepository.delete(entidade);
    }


    public List<Aluno> listarTodos(){
        return this.alunoRepository.findAll();
    }

    @Cacheable(value="alunos", key="#matricula")
    public Aluno selecionaAlunoByMatricula(String matricula){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.alunoRepository.findByMatricula(matricula).orElseThrow(AlunoNaoEncontradoException::new);
    }
}
