package br.com.letscode.cursosead.exception;

public class CursoNaoEncontradoException extends RuntimeException{
    public CursoNaoEncontradoException(){
        super("Curso não encontrado");
    }
}
