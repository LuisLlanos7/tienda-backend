/**
 * 
 */
package com.todo1.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todo1.tienda.entity.MovimientoDetalle;

/**
 * @author Luis
 *
 */
@Repository
public interface MovimientoDetalleRepository extends JpaRepository<MovimientoDetalle, Long> {

}
