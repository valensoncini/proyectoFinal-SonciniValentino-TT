package com.proyecto.ValentinoSoncini.demo.services;

import org.springframework.stereotype.Service;

import com.proyecto.ValentinoSoncini.demo.models.ArticuloModel;
import com.proyecto.ValentinoSoncini.demo.repositories.ArticuloRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ArticulosServiceImplementacion implements ArticuloService{
	
	private final ArticuloRepository repoArticulo;
	
	@Autowired
	public ArticulosServiceImplementacion( ArticuloRepository repoArticulo) {
		this.repoArticulo = repoArticulo;
	}

	
	public List<ArticuloModel> listarArticulos() {
		return repoArticulo.findAll();
	}

	
	public Optional<ArticuloModel> obtenerArticuloPorId(Long id) {
		return repoArticulo.findById(id);
	}

	
	public ArticuloModel guardarArticulo(ArticuloModel articulo) {
		return repoArticulo.save(articulo);
	}

	
	public ArticuloModel actualizarArticulo(Long id, ArticuloModel articulo) {
		articulo.setId(id);
		return repoArticulo.save(articulo);
	}

	
	public void eliminarArticulo(Long id) {
		repoArticulo.deleteById(id);
	}
	
	
	
	

}
