package br.com.tex.hotelhapi.model.dto.erro;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class ErroOutputDto {
    private String campo;
    private String descricao;
}