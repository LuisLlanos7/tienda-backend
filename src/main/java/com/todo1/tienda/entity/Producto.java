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

import lombok.Data;

/**
 * @author Luis
 *
 */
@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_codigo")
	private String codigo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tip_id")
	private TipoProducto tipoProducto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mar_id")
	private Marca marca;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_descripcion")
	private String descripcion;	
	
	@Column(name = "prod_stock")
	private int stock;
	
	@Column(name = "prod_estado")
	private int estado;		

}
