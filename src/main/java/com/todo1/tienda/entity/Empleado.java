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
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_codigo")
	private String codigo;

	@Column(name = "emp_nombres")
	private String nombres;

	@Column(name = "emp_apellidos")
	private String apellidos;

	@Column(name = "emp_identificacion")
	private int identificacion;

}
