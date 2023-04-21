package br.com.tex.hotelhapi.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioLoginInputDto {
    private String email;
    private String senha;
}
