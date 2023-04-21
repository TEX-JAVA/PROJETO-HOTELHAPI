package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Hotel;
import lombok.Getter;
import java.util.List;
@Getter
public class ServicosPorHotelOutputDto {
    private List<ServicoOutputDto> servicos;

    public ServicosPorHotelOutputDto(Hotel hotel){
        this.servicos = hotel.getServicos()
                .stream().map(servico -> new ServicoOutputDto(servico)).toList();
    }
}


