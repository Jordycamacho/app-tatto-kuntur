package com.example.tattoC.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tattoC.entity.Contact;

public interface IContactDAO {

	public abstract Contact addUsuarios(Contact contacto);
	
	public abstract List<Contact> ListAllContact();
	
	public  abstract Contact findContactById(long id);
	
	public abstract void removeContactos(long id);
	
}
