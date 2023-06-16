package com.pragma.library.Controlador;

import com.pragma.library.entidad.Autor;
import com.pragma.library.servicio.AutorServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autores")
@Tag(name = "servicio autores", description = "servicios que ofrecen CRUD en la entidad autores")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @PostMapping
    @Operation(summary = "Registra un autor a la BD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Autor creado con exito"),
            @ApiResponse(responseCode = "400",description = "No se pudo crear el autor")
    })
    public ResponseEntity<Autor> registrar(@RequestBody Autor datos){
        try {
            Autor autorRegistrado = autorServicio.registrar(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(autorRegistrado);
        }catch (Exception error){
            String mensaje = "Error al registrar el autor" + error.getMessage();
            Autor autorError = new Autor();
            autorError.setMensajeError(mensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(autorError);
        }
    }

    @GetMapping
    @Operation(summary = "Listar autores de la BD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Lista de autores"),
            @ApiResponse(responseCode = "400",description = "Error al buscar autores")
    })
    public ResponseEntity <List<Autor>> buscarTodos(){
        try {
            List<Autor> autores = autorServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autores);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar un autor de la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "400", description = "Error, estudiante desconocido")
    })
    public ResponseEntity<Autor> buscarPorId(@PathVariable Integer id){
        try{
            Autor autorEncontrado = autorServicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autorEncontrado);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
