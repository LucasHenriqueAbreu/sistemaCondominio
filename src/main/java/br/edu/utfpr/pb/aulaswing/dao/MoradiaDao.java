package br.edu.utfpr.pb.aulaswing.dao;

import br.edu.utfpr.pb.aulaswing.model.Moradia;
import br.edu.utfpr.pb.aulaswing.model.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Lucas Henrique de Abreu
 */
public class MoradiaDao extends GenericDao<Moradia, Long>{
    
    public List<Usuario> findByNomeLike(String nome){
        Query query = em.createQuery("from Moradia c where "
                + "c.nome LIKE :nome");
        //query.setParameter("nome", nome);// = 'nome'
        query.setParameter("nome", "%" + nome + "%");// = '%nome%'
        return query.getResultList();
    }    
}
