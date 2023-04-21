package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Servico;
import lombok.Getter;
import java.math.BigDecimal;
@Getter
public class ServicoReservaOutputDto {
    private String nome;
    private BigDecimal preco;

    public ServicoReservaOutputDto(Servico servico){
        this.nome = servico.getNome();
        this.preco = servico.getPreco();
    }
}
