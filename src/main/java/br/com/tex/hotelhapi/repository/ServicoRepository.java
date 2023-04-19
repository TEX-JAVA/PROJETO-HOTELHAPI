package br.com.tex.hotelhapi.repository;

import br.com.tex.hotelhapi.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {}
