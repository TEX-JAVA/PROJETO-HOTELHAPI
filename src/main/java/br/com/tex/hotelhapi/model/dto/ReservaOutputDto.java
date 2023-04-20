package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
public class ReservaOutputDto {
    private Integer numeroDaReserva;
    private String usuario;
    private String hotel;
    private String quarto;
    private Integer qtdPessoas;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private BigDecimal total;
    private List<ServicoOutputDto> servicos;

    public ReservaOutputDto(Reserva reserva){
        this.numeroDaReserva = reserva.getId();
        this.usuario = reserva.getUsuario().getNome();
        this.hotel = reserva.getHotel().getNome();
        this.quarto = reserva.getQuarto().getNome();
        this.qtdPessoas = reserva.getQtdPessoas();
        this.dataEntrada = reserva.getDataEntrada();
        this.dataSaida = reserva.getDataSaida();
        this.total = reserva.getTotal();
        this.servicos = reserva.getServicos().stream().map(servico -> new ServicoOutputDto(servico)).toList();
    }
}
