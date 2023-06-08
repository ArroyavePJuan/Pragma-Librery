package com.pragma.library.repositorio;

import com.pragma.library.entidad.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, Integer> {

}
