package br.com.tex.hotelhapi.service;

import br.com.tex.hotelhapi.model.Usuario;
import br.com.tex.hotelhapi.model.dto.UsuarioLoginInputDto;
import br.com.tex.hotelhapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario emailExiste(String email){
        return this.usuarioRepository.findByEmail(email);
    }
    public boolean validarSenha(UsuarioLoginInputDto usuarioDto){
        Usuario usuario = emailExiste(usuarioDto.getEmail());
        System.out.println(usuario);
        return usuario != null && usuario.getSenha().equals(usuarioDto.getSenha());
    }
}
