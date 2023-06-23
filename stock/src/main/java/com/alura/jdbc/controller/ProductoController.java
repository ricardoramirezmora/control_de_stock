package com.alura.jdbc.controller;

import java.util.List;

import com.alura.jdbc.categoria.Categoria;
import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.producto.Producto;

public class ProductoController {
	
	ProductoDAO productoDAO;
	
	public ProductoController() {
		
		productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
	}

	public void modificar(String nombre, String descripcion, Integer id, Integer cantidad) {
		
		productoDAO.modificar(nombre,descripcion,id,cantidad);
	}

	public int eliminar(Integer id) {
		
		return productoDAO.eliminar(id); 
	}

	public List<Producto> listar() {
		
		return productoDAO.listar();  
	}
	
	public List<Producto> listar(Categoria categoria){
		
		return productoDAO.listar(categoria.getId()); 
		
	}

    public void guardar(Producto producto, Categoria categoria) {
		
    	producto.setCategoria(categoria);
    	productoDAO.guardar(producto);
	}

}
