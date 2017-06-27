package br.edu.utfpr.pb.aulaswing.controller;

import br.edu.utfpr.pb.aulaswing.dao.MoradiaDao;
import br.edu.utfpr.pb.aulaswing.model.Moradia;
import java.util.List;

/**
 *
 * @author Lucas Henrique de Abreu
 */
public class MoradiaController {
    private MoradiaDao moradiaDao;
    
    public MoradiaController(){
        moradiaDao = new MoradiaDao();
    }
    
    public List<Moradia> listar(){
        return moradiaDao.findAll();
    }
    
    public void salvar(Moradia moradia) throws Exception {
        if ( moradia.getId() != null ){
            moradiaDao.update(moradia);
        }else{
            moradiaDao.insert(moradia);
        }
    }

    public Moradia buscar(Long id) {
        return moradiaDao.findById(id);
    }

    public void remover(Long id) throws Exception {
        moradiaDao.remove(id);
    }
}
