package br.com.tex.hotelhapi.repository;

import br.com.tex.hotelhapi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
    List<Reserva> findByUsuarioId(Integer id);
}
