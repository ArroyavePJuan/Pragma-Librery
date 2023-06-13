package com.pragma.library.Controlador.servicio;

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
        try{
            List<Autor> autores = autorRepositorio.findAll();
            return autores;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Autor buscarPorId(Integer id) throws Exception {
        try {
            Optional<Autor> autorOptional = autorRepositorio.findById(id);
            if (autorOptional.isPresent()){
                return autorOptional.get();
            }else {
                throw new Exception("Autor no existente");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Autor registrar(Autor datos) throws Exception {
        try {
            Autor autorGuardado = autorRepositorio.save(datos);
            return autorGuardado;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Autor actualizar(Integer id, Autor datosNuevos) throws Exception {
        try{
            Optional<Autor> autorOpcional = autorRepositorio.findById(id);
            if (autorOpcional.isPresent()){
                Autor autorActualizado = autorRepositorio.save(datosNuevos);
                return autorActualizado;
            }else {
                throw new Exception("Autor no existente");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Autor> autorOptional = autorRepositorio.findById(id);
            if (autorOptional.isPresent()){
                autorRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Autor no existente");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
