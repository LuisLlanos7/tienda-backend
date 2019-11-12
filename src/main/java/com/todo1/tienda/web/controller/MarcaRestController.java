/**
 * 
 */
package com.todo1.tienda.web.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.service.MarcaService;

/**
 * @author Luis
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/marca")
public class MarcaRestController {

	private static Logger logger = LogManager.getLogger(MarcaRestController.class);

	@Autowired
	MarcaService marcaService;

	@GetMapping(value = "/disponibles", headers = "Accept=application/json")
	public List<Marca> listarDisponibles() {
		logger.debug("listarDisponibles: Controlador listando las marcas disponibles");
		return marcaService.listarDisponibles();
	}

}
