package com.example.gestion_tienda.controller;

import com.example.gestion_tienda.dto.request.ProductoRequestDTO;
import com.example.gestion_tienda.dto.response.ProductoResponseDTO;
import com.example.gestion_tienda.service.impl.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name ="Producto", description = "Procesa todo lo relacionado con producto")
@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoServiceImpl productoService;
    @Operation(summary = "Guarda los productos", description = "Permite guardar los productos ")
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@RequestBody ProductoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardarProducto(dto));
    }
    @Operation(summary = "actualizar los productos", description = "Permite actualizar los productos ")
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(@RequestBody ProductoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(productoService.actualizarProducto(dto, id));
    }
    @Operation(summary = "listar los productos", description = "Permite listar los productos ")

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos(){
        return ResponseEntity.ok().body(productoService.buscarTodos());
    }
    @Operation(summary = "buscar los productos", description = "Permite buscar los productos por id ")

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarId(@PathVariable Long id){
        return ResponseEntity.ok().body(productoService.buscarPorId(id));
    }
    @Operation(summary = "eliminar los productos", description = "Permite eliminar los productos ")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
