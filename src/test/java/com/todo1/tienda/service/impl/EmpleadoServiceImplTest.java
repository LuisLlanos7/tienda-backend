package com.todo1.tienda.service.impl;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.todo1.tienda.repository.EmpleadoRepository;

@RunWith(MockitoJUnitRunner.class)
class EmpleadoServiceImplTest {

	@Mock
	EmpleadoRepository empleadoRepository;

	@InjectMocks
	EmpleadoServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
