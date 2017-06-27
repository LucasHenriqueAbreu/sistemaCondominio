package br.edu.utfpr.pb.aulaswing.controller;

import br.edu.utfpr.pb.aulaswing.dao.CategoriaDao;
import br.edu.utfpr.pb.aulaswing.model.Categoria;
import java.util.List;

public class CategoriaController {
    private CategoriaDao categoriaDao;
    
    public CategoriaController(){
        categoriaDao = new CategoriaDao();
    }
    
    public List<Categoria> listar(){
        return categoriaDao.findAll();
    }

    public List<Object[]> getCategoriaProdutos() {
        return categoriaDao.getCategoriaProdutos();
    }
}
