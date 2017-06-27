package br.edu.utfpr.pb.aulaswing.dao;

import br.edu.utfpr.pb.aulaswing.model.DespesaItem;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Lucas Henrique de Abreu
 */
public class DespesaItensDao extends GenericDao<DespesaItem, Long>{
    
     public List<DespesaItem> findByDespesa(Integer id){
        Query query = em.createQuery("from despesa_item d "
                + " where d.despesa=:id");
        query.setParameter("despesa", id);
        
        return (List<DespesaItem>) (DespesaItem) query.getResultList();
    }
}
