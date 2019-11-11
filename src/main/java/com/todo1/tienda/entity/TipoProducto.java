/**
 * 
 */
package com.todo1.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Luis
 *
 */
@Data
@Entity
@Table(name = "tipo_producto")
public class TipoProducto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tip_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tip_nombre")
	private String nombre;

	@Column(name = "tip_descripcion")
	private String descripcion;

	@Column(name = "tip_estado")
	private int estado;

}
