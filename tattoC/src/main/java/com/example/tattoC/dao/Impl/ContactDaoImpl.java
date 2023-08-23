package com.example.tattoC.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.tattoC.dao.IContactDAO;
import com.example.tattoC.entity.Contact;
import com.example.tattoC.repository.ContactRepository;

@Service("icontactdao")
public class ContactDaoImpl implements IContactDAO{

	@Autowired
	@Qualifier("contactrepository")
	private ContactRepository contactRepository;
	
	@Override
	public Contact addUsuarios(Contact contacto) {
		
		return contactRepository.save(contacto);
		
	}

	@Override
	public List<Contact> ListAllContact() {
		
		List<Contact> cont = new ArrayList<>();
		
		cont = contactRepository.findAll();
		
		return cont;
	
	}

	public Contact findContactById(long id) {
		
		return contactRepository.findById(id).orElse(null);
	
	}

	public void removeContactos(long id) {
		
		Contact co = findContactById(id);
		
		if(null != co) {
			
			contactRepository.delete(co);
			
		}
		
	}

	

}
