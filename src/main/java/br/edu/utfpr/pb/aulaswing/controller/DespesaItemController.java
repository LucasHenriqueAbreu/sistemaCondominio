package br.edu.utfpr.pb.aulaswing.controller;

import br.edu.utfpr.pb.aulaswing.dao.DespesaItensDao;
import br.edu.utfpr.pb.aulaswing.model.DespesaItem;
import java.util.List;

/**
 *
 * @author Lucas Henrique de Abreu
 */
public class DespesaItemController {
    private DespesaItensDao despesaItemDao;
    
    public DespesaItemController(){
        despesaItemDao = new DespesaItensDao();
    }
    
    public List<DespesaItem> findByDespesa(Integer id) {
        return despesaItemDao.findByDespesa(id);
    }
   
}
