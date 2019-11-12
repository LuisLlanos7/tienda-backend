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

}
