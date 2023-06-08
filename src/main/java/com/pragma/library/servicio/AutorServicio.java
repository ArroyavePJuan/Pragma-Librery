package com.pragma.library.servicio;

import com.pragma.library.entidad.Autor;
import com.pragma.library.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio implements ServicioBase<Autor>{

    @Autowired
    protected AutorRepositorio autorRepositorio;

    @Override
    public List<Autor> buscarTodos() throws Exception {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor buscarPorId(Integer id) throws Exception {
        return null;
    }

    @Override
    public Autor registrar(Autor datos) throws Exception {
        try {
            return autorRepositorio.save(datos);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Autor actualizar(Integer id, Autor datosNuevos) throws Exception {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        return false;
    }
}
