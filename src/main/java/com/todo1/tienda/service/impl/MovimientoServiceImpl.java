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

import com.todo1.tienda.entity.Movimiento;
import com.todo1.tienda.entity.MovimientoDetalle;
import com.todo1.tienda.entity.Producto;
import com.todo1.tienda.repository.MovimientoRepository;
import com.todo1.tienda.repository.ProductoRepository;
import com.todo1.tienda.service.MovimientoService;
import com.todo1.tienda.web.util.Constantes;

/**
 * @author Luis
 *
 */
@Transactional
@Service("movimientoService")
public class MovimientoServiceImpl implements MovimientoService {

	private static Logger logger = LogManager.getLogger(MovimientoServiceImpl.class);

	@Autowired
	MovimientoRepository movimientoRepository;

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public void agregar(Movimiento m) {
		logger.debug("agregar : Servicio agregar movimiento");

		for (MovimientoDetalle movimientoDetalle : m.getDetalles()) {
			logger.debug("agregar : Servicio iterando en movimiento detalles");
			System.out.println("ITERANDO ...");
			movimientoDetalle.setMovimiento(m);

			/**
			 * AQUI LA LOGICA PARA AUMENTAR O DISMINUIR EL STOCK DE CADA PRODUCTO
			 */

			int stockAntiguo = movimientoDetalle.getProducto().getStock();
			int stockActualizado = 0;

			if (m.getTipoMovimiento().getId() == Constantes.ENTRADA) {
				logger.debug("agregar : Servicio en movimiento de entrada, producto= ["
						+ movimientoDetalle.getProducto().getId() + " - " + movimientoDetalle.getProducto().getNombre()
						+ "]");
				
				System.out.println("ENTRADA ...");

				stockActualizado = stockAntiguo + movimientoDetalle.getCantidad();

			} else if (m.getTipoMovimiento().getId() == Constantes.SALIDA) {
				logger.debug("agregar : Servicio en movimiento de salida, producto= ["
						+ movimientoDetalle.getProducto().getId() + " - " + movimientoDetalle.getProducto().getNombre()
						+ "]");

				System.out.println("SALIDA ...");
				
				stockActualizado = stockAntiguo - movimientoDetalle.getCantidad();
			}
			
			System.out.println("ANTES DE ACTUALIZAR ...");

			productoRepository.actualizarStock(stockActualizado, movimientoDetalle.getProducto().getId());
		}

		movimientoRepository.save(m);
	}
	
	/**
	@Override
	public List<Movimiento> listarDisponibles() {
		logger.debug("listarDisponibles : Servicio listando movimientos disponibles");
		return movimientoRepository.findAll();
	}
	**/

}
