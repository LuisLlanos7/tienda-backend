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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.tienda.entity.TipoMovimiento;
import com.todo1.tienda.model.Respuesta;
import com.todo1.tienda.service.TipoMovimientoService;
import com.todo1.tienda.web.util.Mensajes;

/**
 * @author Luis
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/tipoMovimiento")
public class TipoMovimientoRestController {

	private static Logger logger = LogManager.getLogger(TipoMovimientoRestController.class);

	@Autowired
	TipoMovimientoService tipoMovimientoService;

	/**
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Respuesta> obtener(@PathVariable("id") long id) {
		logger.debug("obtener: Controlador obtener por id");
		System.out.println("1");

		TipoMovimiento tipoMovimiento = tipoMovimientoService.obtenerPorId(id);
		System.out.println("5");
		
		System.out.println(tipoMovimiento);
		
		System.out.println(tipoMovimiento.getNombre());

		Respuesta respuesta = new Respuesta();
		respuesta.setExito(true);
		respuesta.setCode(200);
		respuesta.setMensaje(Mensajes.BUSQUEDA_CORRECTA);
		respuesta.setData(tipoMovimiento);
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
	**/

}
