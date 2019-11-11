package com.todo1.tienda.service.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.entity.Producto;
import com.todo1.tienda.entity.TipoProducto;
import com.todo1.tienda.repository.ProductoRepository;
import com.todo1.tienda.web.util.Constantes;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
class ProductoServiceImplTest {

	@Mock
	ProductoRepository productoRepository;

	@InjectMocks
	private ProductoServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testListarDisponibles() {
		Mockito.when(productoRepository.listByEstado(Mockito.anyInt())).thenReturn(obtenerListaProductos());

		List<Producto> productos = proceso.listarDisponibles();

		assertTrue(!productos.isEmpty());
	}

	@Test
	void testGetProductosDatatable() {
		fail("Not yet implemented");
	}

	/**
	@Test
	void testAgregarNotNull() {
		Mockito.when(productoRepository.buscarXNombreYCodigo("a", "b")).thenReturn(obtenerListaProductos());

		proceso.agregar(Mockito.any(Producto.class));

	}
	**/

//	@Test
//	void testAgregarNull() {
//		Mockito.when(productoRepository.buscarXNombreYCodigo(Mockito.anyString(), Mockito.anyString()))
//				.thenReturn(obtenerListaProductos());
//		
//		Assertions.assertThrows(ValueNotPermittedException.class, () -> {
//			proceso.agregar(Mockito.any(Producto.class));
//		});
//	}

	@Test
	void testActualizar() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminar() {
		fail("Not yet implemented");
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
