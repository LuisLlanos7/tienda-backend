package com.todo1.tienda.service.impl;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.todo1.tienda.repository.TipoMovimientoRepository;

@RunWith(MockitoJUnitRunner.class)
class TipoMovimientoServiceImplTest {

	@Mock
	TipoMovimientoRepository tipoMovimientoRepository;

	@InjectMocks
	TipoMovimientoServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		initMocks(this);
	}

}
