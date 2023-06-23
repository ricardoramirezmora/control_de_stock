package com.alura.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.categoria.Categoria;
import com.alura.jdbc.dao.CategoriaDAO;
import com.alura.jdbc.factory.ConnectionFactory;

public class CategoriaController {
	
	private CategoriaDAO categoriaDao;
	
	public CategoriaController() {
		
		categoriaDao = new CategoriaDAO(new ConnectionFactory().recuperaConexion());
	}

	public List<Categoria> listar() {
		
		return categoriaDao.listar();
	}

    public List<Categoria> cargaReporte() {
         
        return this.listar();
    }

}
