package com.example.tattoC.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.tattoC.dao.ImageDAO;
import com.example.tattoC.entity.Imagen;
import com.example.tattoC.repository.ImageRepository;

@Service("imagerepository")
public class ImageDaoImpl  implements ImageRepository{
   
	@Autowired
	@Qualifier("imagedao")
	private ImageDAO imageDAO;

	@Override
	public List<Imagen> ListAllImage() {
		
		List<Imagen> img = new ArrayList<>();
		
		img = imageDAO.findAll();
		
		return img;
	}

	@Override
	public Imagen findImageById(long id) {
		
		return imageDAO.findById(id).orElse(null);
		
	}

	@Override
	public void removeImage(long id) {
		
		Imagen im = findImageById(id);
		
		if (null != im) {
			
			imageDAO.delete(im);
			
		}
		
	}
	
	
	
}
