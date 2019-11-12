/**
 * 
 */
package com.todo1.tienda.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.todo1.tienda.entity.Producto;

/**
 * @author Luis
 *
 */
public interface ProductoService {
	
	public Producto getProductoById(long id);

	public void agregar(Producto p);

	public List<Producto> listarDisponibles();

	public DataTablesOutput<Producto> getProductosDatatable(DataTablesInput input);

	public void actualizar(Producto p);

	public void eliminar(long codigo);

}
