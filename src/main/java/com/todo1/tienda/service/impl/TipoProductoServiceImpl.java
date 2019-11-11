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

import com.todo1.tienda.entity.TipoProducto;
import com.todo1.tienda.repository.TipoProductoRepository;
import com.todo1.tienda.service.TipoProductoService;
import com.todo1.tienda.web.util.Constantes;

/**
 * @author Luis
 *
 */
@Transactional
@Service("tipoProductoService")
public class TipoProductoServiceImpl implements TipoProductoService {

	private static Logger logger = LogManager.getLogger(TipoProductoServiceImpl.class);

	@Autowired
	TipoProductoRepository tipoProductoRepository;

	@Override
	public List<TipoProducto> listarDisponibles() {
		logger.debug("listarDisponibles : Servicio listando marcas disponibles");
		return tipoProductoRepository.listByEstado(Constantes.ESTADO_ACTIVO);
	}

}
