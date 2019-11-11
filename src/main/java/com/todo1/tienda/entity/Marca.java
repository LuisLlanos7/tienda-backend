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
import lombok.NoArgsConstructor;

/**
 * @author Luis
 *
 */

@Data
//@NoArgsConstructor
@Entity
@Table(name = "marca")
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mar_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mar_nombre")
	private String nombre;

	@Column(name = "mar_descripcion")
	private String descripcion;

	@Column(name = "mar_estado")
	private int estado;

}
