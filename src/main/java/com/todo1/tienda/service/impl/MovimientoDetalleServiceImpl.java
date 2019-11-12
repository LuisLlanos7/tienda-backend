/**
 * 
 */
package com.todo1.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.tienda.repository.MovimientoDetalleRepository;
import com.todo1.tienda.service.MovimientoDetalleService;

/**
 * @author Luis
 *
 */
@Transactional
@Service("movimientoDetalleService")
public class MovimientoDetalleServiceImpl implements MovimientoDetalleService {

	@Autowired
	MovimientoDetalleRepository movimientoDetalleRepository;

}
