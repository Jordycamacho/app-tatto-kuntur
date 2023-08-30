package com.example.tattoC.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tattoC.entity.Imagen;

@Repository("imagedao")
public interface ImageDAO extends JpaRepository<Imagen, Long>{
	
	public abstract Optional<Imagen> findById(Long id);
	
}
