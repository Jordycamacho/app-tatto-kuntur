package com.example.tattoC.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.tattoC.dao.IContactDAO;
import com.example.tattoC.dao.ImageDAO;
import com.example.tattoC.entity.Contact;
import com.example.tattoC.entity.Imagen;
import com.example.tattoC.utils.RenderizadorPaginas;


@Controller
public class DemoController {
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
	@Qualifier("icontactdao")
	private IContactDAO iContactDAO;
	
	/*URL de administracion*/
	
	
	@GetMapping("/ad")
	public String showDemo(Model model) {
		
		model.addAttribute("imagenes", new Imagen());
		
		return"admin";
	}
	
	@PostMapping("/ad")
	public String guardar(@RequestParam(name = "file", required = false) MultipartFile foto, Imagen imagen, RedirectAttributes flash) {
		
		if (!foto.isEmpty()) {
			
			String ruta ="D://img//ejr";
			String nombreUnico =  UUID.randomUUID().toString()+"-"+foto.getOriginalFilename();
    		
			try {
				
                byte[] bytes = foto.getBytes();
				
				Path rutaAbsoluta = Paths.get(ruta + "//" + nombreUnico);
				
				Files.write(rutaAbsoluta, bytes);
				
				imagen.setFoto(nombreUnico);
				
			} catch (Exception e) {
				
				System.out.print("la imagen no existe");
				
				e.printStackTrace();
			}
			
			imageDAO.save(imagen);
			
			flash.addFlashAttribute("success", " Foto subida");
		}
		
		return"redirect:/ad";
	}
	
	@GetMapping("/ad/lista")
	public ModelAndView showListContact() {
		
        ModelAndView mav = new ModelAndView("mensajes");
		
		mav.addObject("mensajes", iContactDAO.ListAllContact());
		
		return mav;
	}
	
	@GetMapping("/ad/removecontactos")
	public ModelAndView removeCotacts(@RequestParam(name = "id", required = true) Long id) {
		
		iContactDAO.removeContactos(id);
		
		return showListContact();
		
	}
	
	
	
	/*URL de usuarios*/
	
	@GetMapping("/inicio")
	public String showApp() {
		
		return"index";
		
	}
	
	@GetMapping("/inicio/galeria")
	public String showGalery(@RequestParam(name = "page", defaultValue = "0")int page ,Model model) {
		
		PageRequest userPageable = PageRequest.of(page, 3);
		
		Page<Imagen> imagen = imageDAO.findAll(userPageable);
		
		RenderizadorPaginas<Imagen> renderizadorPaginas = new RenderizadorPaginas<Imagen>("/inicio/galeria", imagen);
		
		model.addAttribute("page", renderizadorPaginas);
		
		model.addAttribute("imagenes", imagen);
		
		return"galery";
	}
	
	@GetMapping("/inicio/contacto")
	public String showContact(Model model, @RequestParam(name = "id", required = false) Long id) {
		
		Contact co = new Contact();
		
		model.addAttribute("contactos", co);
		
		return"contact";
	}
	
	
	@PostMapping("/inicio/addcontact")
	public String AddContact(@ModelAttribute(name="contactos")Contact contactos) {
		
		iContactDAO.addUsuarios(contactos);
		
		return "redirect:/inicio/contacto" ;
		
	}
	
	
}
