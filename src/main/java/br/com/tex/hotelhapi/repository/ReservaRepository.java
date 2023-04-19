package br.com.tex.hotelhapi.repository;

import br.com.tex.hotelhapi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {}
