package br.com.tex.hotelhapi.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "servicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private BigDecimal preco;
    @ManyToOne()
    private Hotel hotel;
}