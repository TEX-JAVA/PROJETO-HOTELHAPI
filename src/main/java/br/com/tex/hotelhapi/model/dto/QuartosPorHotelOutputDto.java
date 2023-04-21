package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Hotel;
import lombok.Getter;
import java.util.List;
@Getter
public class QuartosPorHotelOutputDto {
    private List<QuartoOutputDto> quartos;

    public QuartosPorHotelOutputDto(Hotel hotel){
        this.quartos = hotel.getQuartos()
                .stream().map(quarto -> new QuartoOutputDto(quarto)).toList();
    }
}
