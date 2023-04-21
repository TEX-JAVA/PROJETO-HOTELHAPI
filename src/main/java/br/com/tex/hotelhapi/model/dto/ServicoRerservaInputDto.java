package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Servico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class ServicoRerservaInputDto {
    private Integer id;
    private String nome;
    private BigDecimal preco;

    public Servico toServicoParaReserva(){
        Servico servico = new Servico();
        servico.setId(this.id);
        servico.setNome(this.nome);
        servico.setPreco(this.preco);
        return servico;
    }
}
