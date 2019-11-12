/**
 * 
 */
package com.todo1.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.tienda.repository.TipoMovimientoRepository;
import com.todo1.tienda.service.TipoMovimientoService;

/**
 * @author Luis
 *
 */
@Transactional
@Service("tipoMovimientoService")
public class TipoMovimientoServiceImpl implements TipoMovimientoService {

	@Autowired
	TipoMovimientoRepository tipoMovimientoRepository;

}
