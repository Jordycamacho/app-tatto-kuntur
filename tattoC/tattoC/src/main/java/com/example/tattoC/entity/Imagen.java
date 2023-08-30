package com.example.tattoC.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "upload_files")
public class Imagen implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Por favor agrega el autor")
	private String autor;
	@NotBlank(message = "Por favor agrega la categoria")
	private String categoria;
	private String foto;
	private static final long serialVersionUID = 1L;
		
	public Imagen(Long id, String autor, String categoria, String foto) {
		super();
		this.id = id;
		this.autor = autor;
		this.categoria = categoria;
		this.foto = foto;
	}
	
	public Imagen() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
