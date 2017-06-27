package br.edu.utfpr.pb.aulaswing.dao;

import br.edu.utfpr.pb.aulaswing.model.Categoria;
import java.util.List;
import javax.persistence.Query;

public class CategoriaDao extends GenericDao<Categoria, Long>{

    public List<Object[]> getCategoriaProdutos() {
        Query query = em.createQuery("Select c.descricao, "
                + "count(p) from Produto AS p "
                + "INNER JOIN p.categoria AS c "
                + "GROUP BY c.id");
        return (List<Object[]>) query.getResultList();
    }
   
}




