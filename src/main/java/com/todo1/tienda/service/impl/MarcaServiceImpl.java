/**
 * 
 */
package com.todo1.tienda.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.repository.MarcaRepository;
import com.todo1.tienda.service.MarcaService;
import com.todo1.tienda.web.util.Constantes;

/**
 * @author Luis
 *
 */
@Transactional
@Service("marcaService")
public class MarcaServiceImpl implements MarcaService {

	private static Logger logger = LogManager.getLogger(MarcaServiceImpl.class);

	@Autowired
	MarcaRepository marcaRepository;

	@Override
	public List<Marca> listarDisponibles() {
		logger.debug("listarDisponibles : Servicio listando marcas disponibles");
		return marcaRepository.listByEstado(Constantes.ESTADO_ACTIVO);
	}

}
