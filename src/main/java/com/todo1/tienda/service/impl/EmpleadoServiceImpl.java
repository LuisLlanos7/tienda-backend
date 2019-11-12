/**
 * 
 */
package com.todo1.tienda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.tienda.repository.EmpleadoRepository;
import com.todo1.tienda.service.EmpleadoService;

/**
 * @author Luis
 *
 */
@Transactional
@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;

}
