package com.ciberfarma.tema03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ciberfarma.tema03.model.Producto;
import com.ciberfarma.tema03.repository.ICategoriaRepository;
import com.ciberfarma.tema03.repository.IProductoRepository;
import com.ciberfarma.tema03.repository.IProveedorRepository;

@Controller
public class ProductoController {

	@Autowired
	private IProductoRepository repoProd;

	@Autowired
	private ICategoriaRepository repoCat;

	@Autowired
	private IProveedorRepository repoProv;

	@GetMapping({ "/cargar", "/" })
	public String cargarPagCrud(Model model) {
		// acciones
		model.addAttribute("producto", new Producto());
		// Listado
		model.addAttribute("lstCategorias", repoCat.findAll());
		model.addAttribute("lstProductos", repoProd.findAll());
		model.addAttribute("lstProveedores", repoProv.findAll());
		// retorno
		return "crudproductos";
	}

	@PostMapping("/grabar")
	public String grabar(@ModelAttribute Producto producto, Model model) {
		// acciones
		System.out.println(producto);

		try {
			repoProd.save(producto);
			// enviar mensajes de éxito
			model.addAttribute("mensaje", "Registro Ok");
			model.addAttribute("cssmensaje", "alert alert-success");

		} catch (Exception e) {
			model.addAttribute("mensaje", "Hubo un error en el registro");
			model.addAttribute("cssmensaje", "alert alert-success");
		}

		// Listado
//		model.addAttribute("lstCategorias", repoCat.findAll());
//		model.addAttribute("lstProductos", repoProd.findAll());
//		model.addAttribute("lstProveedores", repoProv.findAll());

		// retorno
//		return "crudproductos";
		return "redirect:/";
	}

	@GetMapping("/editar/{id_prod}")
	public String editar(Model model, @PathVariable String id_prod) {

		// acciones
		Producto p = repoProd.findById(id_prod).get();

		model.addAttribute("producto", p);
		// Listado
		model.addAttribute("lstCategorias", repoCat.findAll());
		model.addAttribute("lstProductos", repoProd.findAll());
		model.addAttribute("lstProveedores", repoProv.findAll());
		// retorno
		return "crudproductos";
	}

}
