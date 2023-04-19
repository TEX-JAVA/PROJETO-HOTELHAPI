package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.ClasseUsuario;
import br.com.tex.hotelhapi.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInputDto {
    private String nome;
    private String email;
    private String senha;
    private Integer classeUsuarioId;
    public Usuario toUsuario(ClasseUsuario classeUsuario){
        Usuario usuario = new Usuario();
        usuario.setNome(this.getNome());
        usuario.setEmail(this.getEmail());
        usuario.setSenha(this.getSenha());
        usuario.setClasseUsuario(classeUsuario);
        return  usuario;

    }
}
