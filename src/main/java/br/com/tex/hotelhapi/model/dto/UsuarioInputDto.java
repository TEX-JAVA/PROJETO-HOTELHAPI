package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.ClasseUsuario;
import br.com.tex.hotelhapi.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class UsuarioInputDto {
    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    private String nome;
    @NotBlank(message = "E-mail não pode ser vazio ou nulo")
    private String email;
    @Size(min = 3, message = "A senha deve conter no mínimo 3 caracteres.")
    private String senha;
    @NotNull
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
