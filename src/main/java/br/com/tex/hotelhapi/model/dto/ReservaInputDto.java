package br.com.tex.hotelhapi.model.dto;

import br.com.tex.hotelhapi.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class ReservaInputDto {
    @DateTimeFormat
    @NotNull
    private LocalDate dataEntrada;
    @DateTimeFormat
    @NotNull
    private LocalDate dataSaida;
    @Min(1)
    private Integer qtdPessoas;
    private BigDecimal total;
    @NotNull
    private Integer idHotel;
    @NotNull
    private Integer idUsuario;
    @NotNull
    private Integer idQuarto;
    private List<ServicoRerservaInputDto> servicos;

    public Reserva toReserva(Hotel hotel, Usuario usuario, Quarto quarto){
        List<Servico> servicos = new ArrayList<>();

        if(this.servicos != null){
            for(ServicoRerservaInputDto servicoDto : this.servicos){
                servicos.add(servicoDto.toServicoParaReserva());
            }
        }

        Reserva reserva = new Reserva();
        reserva.setDataEntrada(this.dataEntrada);
        reserva.setDataSaida(this.dataSaida);
        reserva.setQtdPessoas(this.qtdPessoas);
        reserva.setTotal(this.total);
        reserva.setHotel(hotel);
        reserva.setQuarto(quarto);
        reserva.setUsuario(usuario);
        reserva.setServicos(servicos);

        return reserva;
    }
}
