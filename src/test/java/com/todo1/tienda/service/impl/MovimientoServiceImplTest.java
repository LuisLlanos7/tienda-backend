package com.todo1.tienda.service.impl;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.todo1.tienda.repository.MovimientoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MovimientoServiceImplTest {
	
	@Mock
	MovimientoRepository movimientoRepository;

	@InjectMocks
	private MovimientoServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAgregar() {
		fail("Not yet implemented");
	}	
	

}
