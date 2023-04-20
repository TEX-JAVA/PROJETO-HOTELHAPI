package br.com.tex.hotelhapi.repository;

import br.com.tex.hotelhapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
