package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.Usuario;
import lombok.Getter;
import java.util.List;
@Getter
public class ReservaPorUsuarioOutputDto {
    private String nome;
    private List<ReservaSimplificadaPorUsuarioDto> reservas;
    public ReservaPorUsuarioOutputDto(Usuario usuario){
        this.nome = usuario.getNome();
        this.reservas = usuario.getReservas()
                .stream().map(reserva -> new ReservaSimplificadaPorUsuarioDto(reserva)).toList();
    }
}