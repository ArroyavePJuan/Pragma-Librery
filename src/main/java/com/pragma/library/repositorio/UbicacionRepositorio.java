package com.pragma.library.repositorio;

import com.pragma.library.entidad.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, Integer> {

}
