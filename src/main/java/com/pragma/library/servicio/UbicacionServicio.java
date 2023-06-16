package com.pragma.library.servicio;

import com.pragma.library.entidad.Ubicacion;
import com.pragma.library.repositorio.UbicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionServicio implements ServicioBase<Ubicacion>{

    @Autowired
    private UbicacionRepositorio ubicacionRepositorio;


    @Override
    public List<Ubicacion> buscarTodos() throws Exception {
        try {
            List<Ubicacion> ubicaciones = ubicacionRepositorio.findAll();
            return ubicaciones;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Ubicacion buscarPorId(Integer id) throws Exception {
        try {
            Optional<Ubicacion> ubicacionOptional = ubicacionRepositorio.findById(id);
            if (ubicacionOptional.isPresent()){
                return ubicacionOptional.get();
            }else {
                throw new Exception("No se encontro la ubicacion");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Ubicacion registrar(Ubicacion datos) throws Exception {
        try {
            Ubicacion ubicacionRegistrada = ubicacionRepositorio.save(datos);
            return ubicacionRegistrada;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Ubicacion actualizar(Integer id, Ubicacion datosNuevos) throws Exception {
        try {
            Optional<Ubicacion> ubicacionOptional = ubicacionRepositorio.findById(id);
            if (ubicacionOptional.isPresent()){
                return ubicacionOptional.get();
            }else {
                throw new Exception("No se encontro ubicacion");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public boolean eliminar(Integer id) throws Exception {
        try {
            Optional<Ubicacion> ubicacionEliminada = ubicacionRepositorio.findById(id);
            if (ubicacionEliminada.isPresent()){
                ubicacionRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("No se encontro ubicacion");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
