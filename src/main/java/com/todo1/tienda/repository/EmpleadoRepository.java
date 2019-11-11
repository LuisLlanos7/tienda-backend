/**
 * 
 */
package com.todo1.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo1.tienda.entity.Empleado;

/**
 * @author Luis
 *
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
