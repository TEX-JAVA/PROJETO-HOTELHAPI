package br.com.tex.hotelhapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "classes_usuarios")
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
    @JsonManagedReference
    private List<Usuario> usuarios;
}
