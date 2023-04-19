package br.com.tex.hotelhapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "classesUsuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClasseUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    @OneToMany(mappedBy = "classeUsuario")
    private List<Usuario> usuarios;
}
