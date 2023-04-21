package br.com.tex.hotelhapi.repository;

import br.com.tex.hotelhapi.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {}
