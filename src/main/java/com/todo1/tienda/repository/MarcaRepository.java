/**
 * 
 */
package com.todo1.tienda.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo1.tienda.entity.Marca;

/**
 * @author Luis
 *
 */
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
	
	@Query("SELECT m FROM Marca m WHERE m.estado =:estado")
	List<Marca> listByEstado(@Param("estado") int estado);

}
