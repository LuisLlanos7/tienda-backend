/**
 * 
 */
package com.todo1.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo1.tienda.entity.TipoProducto;

/**
 * @author Luis
 *
 */
@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
	
	@Query("SELECT m FROM TipoProducto m WHERE m.estado =:estado")
	List<TipoProducto> listByEstado(@Param("estado") int estado);

}
