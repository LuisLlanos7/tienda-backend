/**
 * 
 */
package com.todo1.tienda.web.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.tienda.entity.Movimiento;
import com.todo1.tienda.model.Respuesta;
import com.todo1.tienda.service.MovimientoService;
import com.todo1.tienda.web.util.Mensajes;

/**
 * @author Luis
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/movimiento")
public class MovimientoRestController {

	private static Logger logger = LogManager.getLogger(MovimientoRestController.class);

	@Autowired
	MovimientoService movimientoService;

	@PostMapping(headers = "Accept=application/json")
	public ResponseEntity<Respuesta> agregar(@RequestBody Movimiento movimiento) {
		logger.debug("agregar: Controlador agregar movimiento");

		movimientoService.agregar(movimiento);

		Respuesta respuesta = new Respuesta();
		respuesta.setExito(true);
		respuesta.setCode(200);
		respuesta.setMensaje(Mensajes.ADICION_CORRECTA);
		respuesta.setData(null);
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}

}
