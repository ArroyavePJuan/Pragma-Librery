package com.pragma.library.servicio;

import com.pragma.library.entidad.Editorial;
import com.pragma.library.repositorio.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServicio implements ServicioBase<Editorial>{

    @Autowired
    protected EditorialRepositorio editorialRepositorio;

    @Override
    public List buscarTodos() throws Exception {
        try{
            List<Editorial> editoriales = editorialRepositorio.findAll();
            return editoriales;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Editorial buscarPorId(Integer id) throws Exception {
        try {
            Optional<Editorial> editorialOptional =  editorialRepositorio.findById(id);
            if (editorialOptional.isPresent()){
                return editorialOptional.get();
            }else {
                throw new Exception("Editorial no registrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Editorial registrar(Editorial datos) throws Exception {
        try {
            Editorial editorialGuardada = editorialRepositorio.save(datos);
            return editorialGuardada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Editorial actualizar(Integer id, Editorial datosNuevos) throws Exception {
        try{
            Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
            if (editorialOptional.isPresent()){
                Editorial editorialActualizada = editorialRepositorio.save(datosNuevos);
                return editorialActualizada;
            }else {
                throw new Exception("Editorial no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try{
            Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
            if (editorialOptional.isPresent()){
                editorialRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Editorial no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
