package com.todo1.tienda.service.impl;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.todo1.tienda.repository.MovimientoDetalleRepository;

@RunWith(MockitoJUnitRunner.class)
class MovimientoDetalleServiceImplTest {

	@Mock
	MovimientoDetalleRepository movimientoDetalleRepository;

	@InjectMocks
	MovimientoDetalleServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		initMocks(this);
	}


}
