package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Quarto;
import lombok.Getter;
import java.math.BigDecimal;
@Getter
public class QuartoOutputDto {
    private Integer id;
    private String nome;
    private BigDecimal preco;

    public QuartoOutputDto(Quarto quarto){
        this.id = quarto.getId();
        this.nome = quarto.getNome();
        this.preco = quarto.getPreco();
    }
}
