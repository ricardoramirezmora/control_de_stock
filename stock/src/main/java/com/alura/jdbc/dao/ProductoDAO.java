package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.producto.Producto;

public class ProductoDAO {
	
	private Connection con;
	
	public ProductoDAO(Connection con) {
		
		this.con = con;
	}

	public List<Producto> listar() {
		
		List<Producto> resultado = new ArrayList<>();
		
		try {
			
			final PreparedStatement statement = con.prepareStatement("SELECT id,nombre,descripcion,cantidad FROM producto");
			
			try(statement){
				
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					
					while(resultSet.next()) {
						
						Producto fila = new Producto(resultSet.getInt("id"),resultSet.getString("nombre"),resultSet.getString("descripcion"),resultSet.getInt("cantidad"));
						
						resultado.add(fila);
					}
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		return resultado; 
	}

	public void guardar(Producto producto) {
		
		try {
			
			final PreparedStatement statement = con.prepareStatement("INSERT INTO producto(nombre,descripcion,cantidad,id_categoria)VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				
				statement.setString(1, producto.getNombre());
				statement.setString(2, producto.getDescripcion());
				statement.setInt(3, producto.getCantidad());
				statement.setInt(4, producto.getCategoria().getId());
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet){
					
					while(resultSet.next()) {
						
						System.out.println(String.format("Se guardó el producto con ID %d", resultSet.getInt(1)));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public int eliminar(Integer id) {
		
		try {
			
			final PreparedStatement statement = con.prepareStatement("DELETE FROM producto WHERE id = " + id);
			
			statement.execute();
			
			int filasEliminadas = statement.getUpdateCount();
			
			return filasEliminadas; 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void modificar(String nombre, String descripcion, Integer id, Integer cantidad) {
		
		try {
			
			final PreparedStatement statement = con.prepareStatement("UPDATE producto SET nombre = ?,descripcion = ?,cantidad = ? WHERE id = ?");
			
			try(statement){
				
				statement.setString(1, nombre);
				statement.setString(2, descripcion);
				statement.setInt(3, cantidad);
				statement.setInt(4, id);
				statement.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Producto> listar(Integer categoriaId) {
		
		List<Producto> resultado = new ArrayList<>();
		
		try {
			
			final PreparedStatement statement = con.prepareStatement("SELECT id,nombre,descripcion,cantidad FROM producto WHERE id_categoria = ?");
			
			try(statement){
				
				statement.setInt(1, categoriaId);
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					
					while(resultSet.next()) {
						
						Producto fila = new Producto(resultSet.getInt("id"),resultSet.getString("nombre"),resultSet.getString("descripcion"),resultSet.getInt("cantidad"));
						
						resultado.add(fila);
					}
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		return resultado; 
	}

}
