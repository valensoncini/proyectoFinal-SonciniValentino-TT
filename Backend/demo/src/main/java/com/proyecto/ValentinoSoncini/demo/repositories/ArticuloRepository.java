package com.proyecto.ValentinoSoncini.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ValentinoSoncini.demo.models.ArticuloModel;

@Repository
public interface ArticuloRepository extends JpaRepository<ArticuloModel, Long>{
	
	 // ===============================================
    // 🚀 MÉTODOS CRUD INCLUIDOS AUTOMÁTICAMENTE
    // ===============================================
    // findAll()                -> Lista todos los artículos
    // findById(Long id)        -> Busca uno por ID
    // save(Articulo a)         -> Inserta o actualiza
    // deleteById(Long id)      -> Elimina por ID
    // count()                  -> Cuenta registros
    // existsById(Long id)      -> Verifica si existe un ID

    // ===============================================
    // 🛠️ MÉTODOS PERSONALIZADOS (se generan por nombre)
    // ===============================================
	
	// Buscar artículos por nombre exacto
    List<ArticuloModel> findByNombre(String nombre);

    // Buscar artículos cuyo nombre contenga una palabra (LIKE '%texto%')
    List<ArticuloModel> findByNombreContaining(String texto);

    // Buscar artículos con precio mayor a un valor dado
    List<ArticuloModel> findByPrecioGreaterThan(Double precio);

    // Buscar artículos con precio entre dos valores
    List<ArticuloModel> findByPrecioBetween(Double min, Double max);

    // Buscar por nombre ignorando mayúsculas y minúsculas
    List<ArticuloModel> findByNombreIgnoreCase(String nombre);

    // Buscar artículos ordenados por precio ascendente
    List<ArticuloModel> findAllByOrderByPrecioAsc();

    // Buscar artículos por nombre y precio mayor a cierto valor
    List<ArticuloModel> findByNombreAndPrecioGreaterThan(String nombre, Double precio);
	
}
