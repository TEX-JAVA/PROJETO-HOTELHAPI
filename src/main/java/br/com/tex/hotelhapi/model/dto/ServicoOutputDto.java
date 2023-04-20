package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Servico;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class ServicoOutputDto {
    private String nome;
    private BigDecimal preco;

    public ServicoOutputDto(Servico servico){
        this.nome = servico.getNome();
        this.preco = servico.getPreco();
    }
}
