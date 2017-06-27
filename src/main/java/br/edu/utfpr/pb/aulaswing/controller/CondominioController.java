package br.edu.utfpr.pb.aulaswing.controller;

import br.edu.utfpr.pb.aulaswing.dao.CondominioDao;
import br.edu.utfpr.pb.aulaswing.model.Condominio;
import java.util.List;

/**
 *
 * @author Lucas Henrique de Abreu
 */
public class CondominioController {
    private CondominioDao condominioDao;
    
    public CondominioController(){
        condominioDao = new CondominioDao();
    }
    
    public List<Condominio> listar(){
        return condominioDao.findAll();
    }
    
    public void salvar(Condominio condominio) throws Exception {
        if ( condominio.getId() != null ){
            condominioDao.update(condominio);
        }else{
            condominioDao.insert(condominio);
        }
    }

    public Condominio buscar(Long id) {
        return condominioDao.findById(id);
    }

    public void remover(Long id) throws Exception {
        condominioDao.remove(id);
    }
}
