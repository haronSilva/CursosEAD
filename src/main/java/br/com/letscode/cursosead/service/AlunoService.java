package br.com.letscode.cursosead.service;

import br.com.letscode.cursosead.exception.AlunoCadastradoException;
import br.com.letscode.cursosead.exception.AlunoNaoEncontradoException;
import br.com.letscode.cursosead.model.Aluno;
import br.com.letscode.cursosead.repository.AlunoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }


    public void salvarAluno(Aluno aluno){

        if(!this.alunoRepository.existsByMatricula(aluno.getMatricula())){
            this.alunoRepository.save(aluno);
        } else {
            throw new AlunoCadastradoException();
        }

    }

    public Aluno selecionaAlunoByMatricula(String matricula){
        return this.alunoRepository.findByMatricula(matricula).orElseThrow(AlunoNaoEncontradoException::new);
    }
}
