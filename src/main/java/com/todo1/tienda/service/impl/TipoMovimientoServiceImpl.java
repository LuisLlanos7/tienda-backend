/**
 * 
 */
package com.todo1.tienda.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.tienda.entity.TipoMovimiento;
import com.todo1.tienda.exception.ObjectNotFoundException;
import com.todo1.tienda.repository.TipoMovimientoRepository;
import com.todo1.tienda.service.TipoMovimientoService;
import com.todo1.tienda.web.util.Mensajes;

/**
 * @author Luis
 *
 */
@Transactional
@Service("tipoMovimientoService")
public class TipoMovimientoServiceImpl implements TipoMovimientoService {

	private static Logger logger = LogManager.getLogger(TipoMovimientoServiceImpl.class);

	@Autowired
	TipoMovimientoRepository tipoMovimientoRepository;

	/**
	@Override
	public TipoMovimiento obtenerPorId(long id) {
		logger.debug("obtenerPorId : Servicio obteniendo por id");
		
		System.out.println("2");

		TipoMovimiento tipoMovimiento = tipoMovimientoRepository.getOne(id);
		
		System.out.println("3");

		if (tipoMovimiento == null) {
			logger.debug("obtenerPorId : Servicio no existe el tipo movimiento");
			System.out.println("4");
			throw new ObjectNotFoundException(Mensajes.BUSQUEDA_INCORRECTA);
		}

		return tipoMovimiento;
	}
	**/

}
