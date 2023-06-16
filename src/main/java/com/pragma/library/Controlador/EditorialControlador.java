package com.pragma.library.Controlador;

import com.pragma.library.entidad.Editorial;
import com.pragma.library.servicio.EditorialServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/editoriales")
@Tag(name = "Servicio editoriales", description = "servicios que ofrecen CRUD en la entidad Editorial")
public class EditorialControlador {

    @Autowired
    protected EditorialServicio editorialServicio;

    @PostMapping
    @Operation(summary = "Registra una editorial en la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Editorial creado con exito"),
            @ApiResponse(responseCode = "400", description = "Error en el registro")
    })
    public ResponseEntity<Editorial> registrar (@RequestBody Editorial datos){
        try {
            Editorial editorialRegistrada = editorialServicio.registrar(datos);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(editorialRegistrada);
        }catch (Exception error){
            String mensaje = "Error al registrar la editorial" + error.getMessage();
            Editorial editorialError = new Editorial();
            editorialError.setMensajeError(mensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(editorialError);
        }
    }

    @GetMapping
    @Operation(summary = "Listar editoriales de la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Listados"),
            @ApiResponse(responseCode = "400", description = "Error")
    })
    public ResponseEntity <List<Editorial>> buscarTodos(){
        try {
            List<Editorial> editoriales = editorialServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editoriales);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar una editorial de la BD")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "400", description = "Error, estudiante desconocido")
    })
    public ResponseEntity<Editorial> buscarPorId(@PathVariable Integer id){
        try{
            Editorial editorialEncontrado = editorialServicio.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editorialEncontrado);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
