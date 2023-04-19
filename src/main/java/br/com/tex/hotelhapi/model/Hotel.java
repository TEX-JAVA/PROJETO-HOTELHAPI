package br.com.tex.hotelhapi.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hoteis")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String endereco;
    @OneToMany(mappedBy = "hotel")
    private List<Reserva> reservas;
    @OneToMany(mappedBy = "hotel")
    private List<Quarto>quartos;
    @OneToMany(mappedBy = "hotel")
    private List<Servico>servicos;
}
