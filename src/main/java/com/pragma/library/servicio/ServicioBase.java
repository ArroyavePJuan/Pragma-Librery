package com.pragma.library.servicio;

import com.pragma.library.entidad.Editorial;

import java.util.List;

public interface ServicioBase <E> {

    public List<E> buscarTodos() throws Exception;

    public E buscarPorId(Integer id) throws Exception;

    public E registrar(E datos) throws Exception;

    public E actualizar(Integer id, E datosNuevos) throws Exception;

    public boolean eliminar(Integer id) throws Exception;
}
