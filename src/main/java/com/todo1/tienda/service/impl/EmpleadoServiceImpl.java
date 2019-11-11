/**
 * 
 */
package com.todo1.tienda.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

	private static Logger logger = LogManager.getLogger(EmpleadoServiceImpl.class);

	@Autowired
	EmpleadoRepository empleadoRepository;

}
