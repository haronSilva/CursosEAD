package br.com.letscode.cursosead.exception;

public class AlunoCadastradoException extends RuntimeException{
    public AlunoCadastradoException(){
        super("Aluno já cadastrado");
    }
}
