package com.proyecto.ValentinoSoncini.demo.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.ValentinoSoncini.demo.models.ArticuloModel;

public interface ArticuloService {
	List<ArticuloModel> listarArticulos();
	Optional<ArticuloModel> obtenerArticuloPorId(Long id);
	ArticuloModel guardarArticulo(ArticuloModel articulo);
	ArticuloModel actualizarArticulo(Long id, ArticuloModel articulo);
	void eliminarArticulo(Long id);
	
	

}
