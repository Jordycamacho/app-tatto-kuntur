package com.example.tattoC.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "info_contact")
public class Contact {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El correo esta vacio")
	@Email(message = "El correo  no es valido")
	private String correo;
	
	@NotEmpty(message = "La descripcion esta vacia")
	@Size(min =15, max = 500, message = "la descipcion debe tener un minimo de 15 caracteres")
	private String descripcion;
	
	public Contact(String correo, String descripcion) {
		this.correo = correo;
		this.descripcion = descripcion;
	}
	
	public Contact() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
