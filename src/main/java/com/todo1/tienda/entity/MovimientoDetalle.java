/**
 * 
 */
package com.todo1.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author Luis
 *
 */
@Data
@Entity
@Table(name = "movimiento_detalle")
public class MovimientoDetalle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mde_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mov_id")
	@JsonIgnore
	private Movimiento movimiento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prod_id")
	private Producto producto;
	
	@Column(name = "mde_cantidad")
	private int cantidad;

}
