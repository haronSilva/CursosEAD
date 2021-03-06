package br.com.letscode.cursosead.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotBlank(message = "Nome não informado")
    private String nome;

    @Column
    @NotBlank(message = "Matrícula não informada")
    @Pattern(regexp = "^AL\\d{4}$", message = "Matrícula fora do padrão - formato: ALXXXX")
    @Length(max = 10, message ="Quantidade máxima de caracteres excedida")
    private String matricula;

}
