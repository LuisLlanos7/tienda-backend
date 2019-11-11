package com.todo1.tienda.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.entity.TipoProducto;
import com.todo1.tienda.repository.TipoProductoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TipoProductoServiceImplTest {
	
	@Mock
	TipoProductoRepository tipoProductoRepository;

	@InjectMocks
	private TipoProductoServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testListarDisponibles() {
		Mockito.when(tipoProductoRepository.listByEstado(Mockito.anyInt())).thenReturn(obtenerListaTipoProducto());
		List<TipoProducto> tiposProductos = proceso.listarDisponibles();
		assertTrue(!tiposProductos.isEmpty());
	}
	
	
	private List<TipoProducto> obtenerListaTipoProducto() {
		List<TipoProducto> tiposProductos = new ArrayList<TipoProducto>();
		
		TipoProducto tp1 = new TipoProducto();
		tp1.setId(new Long(1));
		tp1.setNombre("CAMISA");
		tp1.setDescripcion("CAMISA");
		tp1.setEstado(1);
		tiposProductos.add(tp1);
		
		TipoProducto tp2 = new TipoProducto();
		tp2.setId(new Long(2));
		tp2.setNombre("GORRA");
		tp2.setDescripcion("GORRA");
		tp2.setEstado(1);
		tiposProductos.add(tp2);
		
		return tiposProductos;
	}
	

}
