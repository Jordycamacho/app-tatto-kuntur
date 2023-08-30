package com.example.tattoC.repository;

import java.util.List;

import com.example.tattoC.entity.Imagen;


public interface ImageRepository {

    public abstract Imagen addImagen(Imagen imagen);
	
	public abstract List<Imagen> ListAllImage();
	
	public  abstract Imagen findImageById(long id);
	
	public abstract void removeImage(long id);
	
}
