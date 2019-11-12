/**
 * 
 */
package com.todo1.tienda.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.tienda.entity.Producto;
import com.todo1.tienda.model.Respuesta;
import com.todo1.tienda.service.ProductoService;
import com.todo1.tienda.web.util.Constantes;
import com.todo1.tienda.web.util.Mensajes;

/**
 * @author Luis
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/producto")
public class ProductoRestController {

	private static Logger logger = LogManager.getLogger(ProductoRestController.class);

	@Autowired
	ProductoService productoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Respuesta> obtener(@PathVariable("id") long id) {
		logger.info("obtener - Controller: obtener por id");
		
		Producto producto = productoService.getProductoById(id);

		Respuesta respuesta = new Respuesta();
		respuesta.setExito(true);
		respuesta.setCode(200);
		respuesta.setMensaje(Mensajes.BUSQUEDA_CORRECTA);
		respuesta.setData(producto);
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/datatable", method = RequestMethod.POST)
	public DataTablesOutput<Producto> getDatatable(@Valid @RequestBody DataTablesInput input) {
		logger.debug("getDatatable: Controlador listando datatable de productos");

		DataTablesOutput<Producto> productos = productoService.getProductosDatatable(input);
		return productos;
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Respuesta> agregar(@RequestBody Producto producto) {
		logger.debug("agregar: Controlador agregar producto");

		productoService.agregar(producto);

		Respuesta respuesta = new Respuesta();
		respuesta.setExito(true);
		respuesta.setCode(200);
		respuesta.setMensaje(Mensajes.ADICION_CORRECTA);
		respuesta.setData(null);
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Respuesta> modificar(@RequestBody Producto producto) {
		logger.debug("modificar: Controlador modificar producto");

		productoService.actualizar(producto);

		Respuesta respuesta = new Respuesta();
		respuesta.setExito(true);
		respuesta.setCode(200);
		respuesta.setMensaje(Mensajes.MODIFICACION_CORRECTA);
		respuesta.setData(null);
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Respuesta> eliminar(@PathVariable("id") long id) {
		logger.debug("eliminar: Controlador eliminar producto");

		productoService.eliminar(id);

		Respuesta respuesta = new Respuesta();
		respuesta.setExito(true);
		respuesta.setCode(200);
		respuesta.setMensaje(Mensajes.ELIMINACION_CORRECTA);
		respuesta.setData(null);
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}

	@RequestMapping(value = "/disponibles", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Producto> listarDisponibles() {
		logger.debug("listarDisponibles: Controlador listar productos disponibles");
		List<Producto> productos = productoService.listarDisponibles();
		return productos;
	}

}
