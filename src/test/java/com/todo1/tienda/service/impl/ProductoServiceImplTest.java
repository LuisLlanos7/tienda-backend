package com.todo1.tienda.service.impl;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;

import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.entity.Producto;
import com.todo1.tienda.entity.TipoProducto;
import com.todo1.tienda.exception.ObjectNotFoundException;
import com.todo1.tienda.exception.ValueNotPermittedException;
import com.todo1.tienda.repository.ProductoRepository;
import com.todo1.tienda.web.util.Constantes;
import com.todo1.tienda.web.util.Mensajes;

@RunWith(MockitoJUnitRunner.class)
class ProductoServiceImplTest {

	@Mock
	ProductoRepository productoRepository;

	@InjectMocks
	ProductoServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		initMocks(this);
	}
	
	@Test
	void testGetProductoById() {
		when(productoRepository.findById(anyLong())).thenReturn(obtenerProductoOpcional());
		Producto producto = proceso.getProductoById(anyLong());
		assertNotNull(producto);
	}
	
	@Test
	void testGetProductoByIdException() {
		//when(productoRepository.findById(anyLong())).thenReturn(obtenerProductoOpcional());
		//Throwable throwable = assertThrows(ObjectNotFoundException.class, () -> proceso.getProductoById(anyLong()));
		//assertEquals(Mensajes.NOT_FOUND, throwable.getMessage());
		
		Exception exception = assertThrows(ObjectNotFoundException.class, () -> proceso.getProductoById(new Long(0)));
		assertEquals(Mensajes.NOT_FOUND, exception.getMessage());
	
	}

	@Test
	void testListarDisponibles() {
		when(productoRepository.listByEstado(anyInt())).thenReturn(obtenerListaProductos());
		List<Producto> productos = proceso.listarDisponibles();
		assertTrue(!productos.isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	void testGetProductosDatatable() {
		when(productoRepository.findAll(any(DataTablesInput.class), (Specification<Producto>) any())).thenReturn(null);
		DataTablesOutput<Producto> output = proceso.getProductosDatatable(null);
		assertNull(output);
	}

	@Test
	void testAgregar() {
		when(productoRepository.buscarXNombreYCodigo(anyString(), anyString())).thenReturn(new ArrayList<Producto>());
		when(productoRepository.save(any())).thenReturn(obtenerProducto());
		proceso.agregar(obtenerProducto());
		verify(productoRepository, times(1)).buscarXNombreYCodigo(anyString(), anyString());
	}

	@Test
	void testAgregarException() {
		when(productoRepository.buscarXNombreYCodigo(anyString(), anyString())).thenReturn(obtenerListaProductos());
		Throwable throwable = assertThrows(ValueNotPermittedException.class, () -> proceso.agregar(obtenerProducto()));
		assertEquals(Mensajes.EXISTENTE, throwable.getMessage());
	}

	@Test
	void testActualizar() {
		when(productoRepository.findById(anyLong())).thenReturn(Optional.of(obtenerProducto()));
		proceso.actualizar(obtenerProducto());
		verify(productoRepository, times(1)).save(any());
	}

	@Test
	void testActualizarException() {
		when(productoRepository.findById(anyLong())).thenReturn(Optional.empty());
		Throwable throwable = assertThrows(ObjectNotFoundException.class, () -> proceso.actualizar(obtenerProducto()));
		assertEquals(Mensajes.NOT_FOUND, throwable.getMessage());
	}

	@Test
	void testEliminar() {
		when(productoRepository.existsById(anyLong())).thenReturn(true);
		proceso.eliminar(obtenerProducto().getId());
		verify(productoRepository, times(1)).setEstadoXCodigo(anyInt(), anyLong());
	}

	@Test
	void testEliminarException() {
		when(productoRepository.existsById(anyLong())).thenReturn(false);
		Throwable throwable = assertThrows(ObjectNotFoundException.class,
				() -> proceso.eliminar(obtenerProducto().getId()));
		assertEquals(Mensajes.NOT_FOUND, throwable.getMessage());
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
	
	private Optional<Producto> obtenerProductoOpcional() {
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

		return Optional.of(p1);
	}
	

	private List<Producto> obtenerListaProductos() {
		List<Producto> productos = new ArrayList<Producto>();

		Producto p1 = new Producto();
		p1.setId(new Long(1));
		p1.setCodigo("CAM-01");
		p1.setNombre("CAMISA-AVANGERS");
		p1.setDescripcion("CAMISA-AVANGERS");
		p1.setEstado(Constantes.ESTADO_ACTIVO);

		Marca m1 = new Marca();
		m1.setId(new Long(1));
		m1.setNombre("MARVEL");
		m1.setDescripcion("MARVEL");
		m1.setEstado(1);
		p1.setMarca(m1);

		TipoProducto tp = new TipoProducto();
		tp.setId(new Long(1));
		tp.setNombre("CAMISA");
		tp.setDescripcion("CAMISA");
		tp.setEstado(1);
		p1.setTipoProducto(tp);

		p1.setStock(40);

		productos.add(p1);

		Producto p2 = new Producto();
		p2.setId(new Long(1));
		p2.setCodigo("CAM-01");
		p2.setNombre("CAMISA-AVANGERS");
		p2.setDescripcion("CAMISA-AVANGERS");
		p2.setEstado(Constantes.ESTADO_ACTIVO);

		p2.setMarca(m1);

		p2.setTipoProducto(tp);

		p2.setStock(20);

		productos.add(p2);

		return productos;
	}

}
