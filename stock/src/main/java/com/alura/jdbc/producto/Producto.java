package com.alura.jdbc.producto;

import com.alura.jdbc.categoria.Categoria;

public class Producto {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	private Categoria categoria;
	
	public Producto() {
		
	}

	public Producto(String nombre, String descripcion, Integer cantidad) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		
	}

	public Producto(int id, String nombre, String descripcion, int cantidad) {
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}