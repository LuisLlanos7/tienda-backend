/**
 * 
 */
package com.todo1.tienda.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

/**
 * @author Luis
 *
 */
@Data
@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mov_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tim_id")
	private TipoMovimiento tipoMovimiento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id")
	private Empleado empleado;
	
	@Column(name = "mov_fecha_hora", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "movimiento", orphanRemoval = true)
	private List<MovimientoDetalle> detalles;

}
