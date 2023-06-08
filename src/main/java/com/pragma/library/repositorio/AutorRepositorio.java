package com.pragma.library.repositorio;

import com.pragma.library.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Integer> {

}
