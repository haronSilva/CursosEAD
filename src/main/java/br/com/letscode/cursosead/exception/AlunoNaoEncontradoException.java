package br.com.letscode.cursosead.exception;

import br.com.letscode.cursosead.model.Aluno;

public class AlunoNaoEncontradoException extends RuntimeException{
    public AlunoNaoEncontradoException(){
        super("Aluno nao encontrado");
    }

}
