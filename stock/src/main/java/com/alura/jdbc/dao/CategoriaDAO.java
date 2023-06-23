package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.categoria.Categoria;

public class CategoriaDAO {
	
	private Connection con;

	public CategoriaDAO(Connection con) {
		
		this.con = con; 
	}

	public List<Categoria> listar() {
		
		List<Categoria> resultado = new ArrayList<>();
		
		try {
			
			final PreparedStatement statement = con.prepareStatement("SELECT id,nombre FROM categoria");
			
			try(statement){
				
				statement.execute(); 
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					
					while(resultSet.next()) {
						
						Categoria fila = new Categoria(resultSet.getInt("id"),resultSet.getString("nombre"));
						
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
