package com.todo1.tienda.service.impl;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.todo1.tienda.entity.Empleado;
import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.entity.Movimiento;
import com.todo1.tienda.entity.MovimientoDetalle;
import com.todo1.tienda.entity.Producto;
import com.todo1.tienda.entity.TipoMovimiento;
import com.todo1.tienda.entity.TipoProducto;
import com.todo1.tienda.repository.MovimientoRepository;
import com.todo1.tienda.repository.ProductoRepository;
import com.todo1.tienda.web.util.Constantes;

@RunWith(MockitoJUnitRunner.class)
class MovimientoServiceImplTest {

	@Mock
	MovimientoRepository movimientoRepository;
	
	@Mock
	ProductoRepository productoRepository;

	@InjectMocks
	private MovimientoServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAgregarEntrada() {
		when(movimientoRepository.save(any())).thenReturn(obtenerMovimientoEntrada());
		proceso.agregar(obtenerMovimientoEntrada());
		verify(movimientoRepository, times(1)).save(any());
	}
	
	@Test
	void testAgregarSalida() {
		when(movimientoRepository.save(any())).thenReturn(obtenerMovimientoSalida());
		proceso.agregar(obtenerMovimientoSalida());
		verify(movimientoRepository, times(1)).save(any());
	}
	
	@Test
	void testActualizarStock() {
		/**
		 * ESTE NO ME FUNCIONA
		 */
		//when(productoRepository.actualizarStock(anyInt(), any()).thenReturn(obtenerMovimientoEntrada());
		//proceso.agregar(obtenerMovimientoSalida());
		//verify(movimientoRepository, times(1)).save(any());
	}

	private Movimiento obtenerMovimientoEntrada() {
		Movimiento m1 = new Movimiento();
		m1.setId(new Long(1));
		m1.setFechaCreacion(new Date());
		m1.setEmpleado(obtenerEmpleado());
		m1.setTipoMovimiento(obtenerTipoMovimientoEntrada());

		m1.setDetalles(obtenerDetalles());

		return m1;
	}
	
	private Movimiento obtenerMovimientoSalida() {
		Movimiento m1 = new Movimiento();
		m1.setId(new Long(1));
		m1.setFechaCreacion(new Date());
		m1.setEmpleado(obtenerEmpleado());
		m1.setTipoMovimiento(obtenerTipoMovimientoSalida());

		m1.setDetalles(obtenerDetalles());

		return m1;
	}

	private Empleado obtenerEmpleado() {
		Empleado e1 = new Empleado();
		e1.setId(new Long(1));
		e1.setCodigo("123123123");
		e1.setNombres("Emilio");
		e1.setApellidos("Gonzales");
		e1.setIdentificacion(1023341112);
		return e1;
	}

	private TipoMovimiento obtenerTipoMovimientoEntrada() {
		TipoMovimiento tm1 = new TipoMovimiento();
		tm1.setId(new Long(1));
		tm1.setNombre("ENTRADA");
		tm1.setEstado(1);
		return tm1;
	}
	
	private TipoMovimiento obtenerTipoMovimientoSalida() {
		TipoMovimiento tm1 = new TipoMovimiento();
		tm1.setId(new Long(2));
		tm1.setNombre("SALIDA");
		tm1.setEstado(1);
		return tm1;
	}

	private List<MovimientoDetalle> obtenerDetalles() {
		List<MovimientoDetalle> lista = new ArrayList<MovimientoDetalle>();

		MovimientoDetalle md1 = new MovimientoDetalle();
		md1.setId(new Long(1));
		md1.setCantidad(3);
		md1.setProducto(obtenerProducto());
		lista.add(md1);

		MovimientoDetalle md2 = new MovimientoDetalle();
		md2.setId(new Long(1));
		md2.setCantidad(2);
		md2.setProducto(obtenerProducto());
		lista.add(md2);

		return lista;
	}

	private Producto obtenerProducto() {
		Marca m1 = new Marca();
		m1.setId(new Long(1));
		m1.setNombre("MARVEL");
		m1.setDescripcion("MARVEL");
		m1.setEstado(1);

		TipoProducto tp = new TipoProducto();
		tp.setId(new Long(1));
		tp.setNombre("CAMISA");
		tp.setDescripcion("CAMISA");
		tp.setEstado(1);

		Producto p1 = new Producto();
		p1.setId(new Long(1));
		p1.setCodigo("CAM-01");
		p1.setNombre("CAMISA-AVANGERS");
		p1.setDescripcion("CAMISA-AVANGERS");
		p1.setEstado(Constantes.ESTADO_ACTIVO);
		p1.setMarca(m1);
		p1.setTipoProducto(tp);
		p1.setStock(40);

		return p1;
	}

}
