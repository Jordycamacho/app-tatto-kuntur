package com.example.tattoC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tattoC.entity.Contact;

@Repository("contactrepository")
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	public abstract Optional<Contact> findById(Long id);
	
}
