package br.edu.utfpr.pb.aulaswing.dao;

import br.edu.utfpr.pb.aulaswing.model.Usuario;
import java.util.List;
import javax.persistence.Query;

public class UsuarioDao extends GenericDao<Usuario, Long>{
   
    
    public Usuario findByEmailAndSenha(String email, 
            String senha){
        Query query = em.createQuery("from Usuario u "
                + " where u.email=:email AND u.senha=:senha");
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        
        return (Usuario) query.getSingleResult();
    }
    
    public List<Usuario> findByNomeLike(String nome){
        Query query = em.createQuery("from Usuario u where "
                + "u.nome LIKE :nome");
        //query.setParameter("nome", nome);// = 'nome'
        query.setParameter("nome", "%" + nome + "%");// = '%nome%'
        return query.getResultList();
    }
    
    
    
    public Usuario findByEmailAndSenhaNamedQuery(String email, 
            String senha){
        Query query = em.createNamedQuery(
                Usuario.FIND_BY_EMAIL_AND_SENHA);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        
        return (Usuario) query.getSingleResult();
    }
}




