package br.edu.utfpr.pb.aulaswing.controller;

import br.edu.utfpr.pb.aulaswing.dao.DespesaDao;
import br.edu.utfpr.pb.aulaswing.model.Despesa;
import java.util.List;

/**
 *
 * @author Lucas Henrique de Abreu
 */
public class DespesaController {
    private DespesaDao despesaDao;
    
    public DespesaController(){
        despesaDao = new DespesaDao();
    }
    
    public List<Despesa> listar(){
        return despesaDao.findAll();
    }
    
    public void salvar(Despesa despesa) throws Exception {
        if ( despesa.getId() != null ){
            despesaDao.update(despesa);
        }else{
            despesaDao.insert(despesa);
        }
    }

    public Despesa buscar(Long id) {
        return despesaDao.findById(id);
    }

    public void remover(Long id) throws Exception {
        despesaDao.remove(id);
    }
}
