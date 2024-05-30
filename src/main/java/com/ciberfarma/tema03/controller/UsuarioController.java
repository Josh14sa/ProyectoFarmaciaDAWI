package com.ciberfarma.tema03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciberfarma.tema03.model.Producto;

@Controller
public class UsuarioController {

	@GetMapping({"/login"})
	public String cargarLogin(Model model) {
		// acciones
		
		// retorno
		return "login";
	}
	
	@PostMapping("/login")
	public String validar(@RequestParam String correo, @RequestParam String clave, 
			Model model) {
		// acciones
		System.out.println(correo + " " + clave);
		
		// validación
		if (correo.equals("admin@mail.com")) {
			return "principal";
		} else {
			// enviar mensajes de éxito
			model.addAttribute("mensaje", "Registro Ok");
			model.addAttribute("cssmensaje", "alert alert-danger");
			// retorno
			return "login";
		}
		
	}
	
	
	
	
}
