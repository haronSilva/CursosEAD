package br.com.letscode.cursosead.repository;

import br.com.letscode.cursosead.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    public Optional<Aluno> findByMatricula(String matricula);
    public boolean existsByMatricula(String matricula);
}
