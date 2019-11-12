/**
 * 
 */
package com.todo1.tienda.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.entity.Producto;
import com.todo1.tienda.entity.TipoProducto;
import com.todo1.tienda.exception.ObjectNotFoundException;
import com.todo1.tienda.exception.ValueNotPermittedException;
import com.todo1.tienda.repository.ProductoRepository;
import com.todo1.tienda.service.ProductoService;
import com.todo1.tienda.web.specifications.ProductoSpecification;
import com.todo1.tienda.web.specifications.SearchCriteria;
import com.todo1.tienda.web.util.Constantes;
import com.todo1.tienda.web.util.Mensajes;

/**
 * @author Luis
 *
 */
@Transactional
@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

	private static Logger logger = LogManager.getLogger(ProductoServiceImpl.class);

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public Producto getProductoById(long id) {
		logger.debug("getProductoById : Servicio getById producto");
        Optional<Producto> optionalProducto = productoRepository.findById(id);

        return optionalProducto.orElseThrow(() -> new ObjectNotFoundException(Mensajes.NOT_FOUND));
	}

	@Override
	public List<Producto> listarDisponibles() {
		logger.debug("listarDisponibles : Servicio listando producto disponibles");
		return productoRepository.listByEstado(Constantes.ESTADO_ACTIVO);
	}

	@Override
	public DataTablesOutput<Producto> getProductosDatatable(DataTablesInput input) {
		logger.debug("getProductosDatatable : Servicio listando producto disponibles datatables");
		ProductoSpecification specification1 = new ProductoSpecification(new SearchCriteria("estado", ":", 1));
		ProductoSpecification specification2 = new ProductoSpecification(new SearchCriteria("estado", ":", 0));
		return productoRepository.findAll(input, Specification.where(specification1).or(specification2));
	}

	@Override
	public void agregar(Producto p) {
		logger.debug("agregar : Servicio agregar producto");

		List<Producto> listaResultado = productoRepository.buscarXNombreYCodigo(p.getNombre(), p.getCodigo());

		logger.debug("agregar : Servicio agregar producto 2 ");

		if (!listaResultado.isEmpty()) {
			logger.debug("getProductosDatatable : El producto ya existe");
			throw new ValueNotPermittedException(Mensajes.EXISTENTE);
		}

		p.setEstado(Constantes.ESTADO_ACTIVO);
		productoRepository.save(p);
	}

	@Override
	public void actualizar(Producto p) {
		logger.debug("actualizar : Servicio actualizar producto");

		Producto producto = productoRepository.findById(p.getId())
				.orElseThrow(() -> new ObjectNotFoundException(Mensajes.NOT_FOUND));

		logger.debug("actualizar : El producto si existe");
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setId(p.getTipoProducto().getId());
		producto.setTipoProducto(tipoProducto);

		Marca marca = new Marca();
		marca.setId(p.getMarca().getId());
		producto.setMarca(marca);

		producto.setNombre(p.getNombre());
		producto.setDescripcion(p.getDescripcion());
		producto.setStock(p.getStock());
		producto.setEstado(p.getEstado());

		productoRepository.save(producto);
	}

	@Override
	public void eliminar(long codigo) {
		logger.debug("eliminar : Servicio eliminar producto");

		boolean existe = productoRepository.existsById(codigo);

		if (existe) {
			logger.debug("eliminar : El producto ya existe");
			productoRepository.setEstadoXCodigo(Constantes.ESTADO_ELIMINADO, codigo);
		} else {
			logger.debug("eliminar : El producto no existe");
			throw new ObjectNotFoundException(Mensajes.NOT_FOUND);
		}

	}

	

}
