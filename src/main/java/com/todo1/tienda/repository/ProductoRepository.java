/**
 * 
 */
package com.todo1.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo1.tienda.entity.Producto;

/**
 * @author Luis
 *
 */
@Repository
public interface ProductoRepository extends DataTablesRepository<Producto, Long> { 

	@Query("SELECT p FROM Producto p WHERE p.estado =:estado")
	List<Producto> listByEstado(@Param("estado") int estado);

	@Query("SELECT p FROM Producto p WHERE (p.nombre =:nombre OR p.codigo =:codigo) AND (p.estado = 1 OR p.estado = 0)")
	List<Producto> buscarXNombreYCodigo(@Param("nombre") String nombre, @Param("codigo") String codigo);
	
	@Modifying
	@Query("update Producto p set p.estado =:estado where p.id =:id")
	void setEstadoXCodigo(@Param("estado") Integer estado, @Param("id") Long id);
	
	@Modifying
	@Query("update Producto p set p.stock =:stock where p.id =:id")
	void actualizarStock(@Param("stock") Integer stock, @Param("id") Long id);

}
