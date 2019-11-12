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

import com.todo1.tienda.entity.TipoProducto;
import com.todo1.tienda.service.TipoProductoService;

/**
 * @author Luis
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/tipoProducto")
public class TipoProductoRestController {

	private static Logger logger = LogManager.getLogger(TipoProductoRestController.class);

	@Autowired
	TipoProductoService tipoProductoService;

	@GetMapping(value = "/disponibles", headers = "Accept=application/json")
	public List<TipoProducto> listarDisponibles() {
		logger.debug("listarDisponibles: Controlador listando tipos productos disponibles");
		return tipoProductoService.listarDisponibles();
	}

}
