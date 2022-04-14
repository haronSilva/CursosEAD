package br.com.letscode.cursosead.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="CURSO_ALUNO",
            joinColumns = {@JoinColumn(name="curso_id")},
            inverseJoinColumns = {@JoinColumn(name="aluno_id")})
    @Valid
    private Set<Aluno> alunos;

}
