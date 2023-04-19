package br.com.tex.hotelhapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "reservas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Integer qtdPessoas;
    private BigDecimal total;
    @ManyToOne
    @JsonBackReference
    private Hotel hotel;
    @ManyToOne
    @JsonBackReference
    private Usuario usuario;
    @ManyToOne
    @JsonBackReference
    private Quarto quarto;
    @ManyToMany
    @JoinTable(name = "reservas_servicos",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id"))
    @JsonManagedReference
    private List<Servico> servicos;
}