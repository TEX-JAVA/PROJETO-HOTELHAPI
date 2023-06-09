package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Servico;
import lombok.Getter;
import java.math.BigDecimal;
@Getter
public class ServicoOutputDto {
    private Integer id;
    private String nome;
    private BigDecimal preco;

    public ServicoOutputDto(Servico servico){
        this.id = servico.getId();
        this.nome = servico.getNome();
        this.preco = servico.getPreco();
    }
}
