package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Usuario;
import lombok.Getter;

@Getter
public class UsuarioOutputDto {
    private Integer id;
    private String nome;
    private String email;
    private String classeUsuario;

    public UsuarioOutputDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.classeUsuario = usuario.getClasseUsuario().getTipo();
    }
}
