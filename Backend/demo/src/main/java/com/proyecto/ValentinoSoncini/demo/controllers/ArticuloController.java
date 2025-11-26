package com.proyecto.ValentinoSoncini.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ValentinoSoncini.demo.models.ArticuloModel;
import com.proyecto.ValentinoSoncini.demo.services.ArticuloService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/articulos")
public class ArticuloController {
	
	private final ArticuloService serviceArticulos;
	
	@Autowired
	public ArticuloController(ArticuloService service) {
		this.serviceArticulos = service;
	}
	
	@GetMapping()
	public List<ArticuloModel> listar(){
		return serviceArticulos.listarArticulos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ArticuloModel> traerPorId(@PathVariable Long id){
		return serviceArticulos.obtenerArticuloPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ArticuloModel crear(@RequestBody ArticuloModel articulo) {
		return serviceArticulos.guardarArticulo(articulo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ArticuloModel> actualizar(@PathVariable Long id, @RequestBody ArticuloModel articulo){
		if(serviceArticulos.obtenerArticuloPorId(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(serviceArticulos.actualizarArticulo(id, articulo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id){
		if(serviceArticulos.obtenerArticuloPorId(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		serviceArticulos.eliminarArticulo(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}
