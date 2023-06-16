package com.pragma.library.servicio;

import com.pragma.library.entidad.Categoria;
import com.pragma.library.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio implements ServicioBase<Categoria>{

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;


    @Override
    public List<Categoria> buscarTodos() throws Exception {
        try {
            List<Categoria> categorias = categoriaRepositorio.findAll();
            return categorias;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Categoria buscarPorId(Integer id) throws Exception {
        try {
            Optional<Categoria> categoriaOptional = categoriaRepositorio.findById(id);
            if (categoriaOptional.isPresent()) {
                return categoriaOptional.get();
            } else {
                throw new Exception("No se encuentra categoria");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Categoria registrar(Categoria datos) throws Exception {
        try {
            Categoria categoriaRegistrada = categoriaRepositorio.save(datos);
            return categoriaRegistrada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Categoria actualizar(Integer id, Categoria datosNuevos) throws Exception {
        try {
            Optional<Categoria> categoriaOptional = categoriaRepositorio.findById(id);
            if (categoriaOptional.isPresent()){
                return categoriaOptional.get();
            }else {
                throw new Exception("No se encontro la categoria");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Categoria> categoriaEliminada = categoriaRepositorio.findById(id);
            if (categoriaEliminada.isPresent()){
                categoriaRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("no se encontro la categoria");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
