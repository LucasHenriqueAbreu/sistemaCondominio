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
    
    public void salvar(Categoria categoria) throws Exception {
        if ( categoria.getId() != null ){
            categoriaDao.update(categoria);
        }else{
            categoriaDao.insert(categoria);
        }
    }
    
    public Categoria buscar(Long id) {
        return categoriaDao.findById(id);
    }
    
    public void remover (Long id) throws Exception  {
        categoriaDao.remove(id);
    }

}
