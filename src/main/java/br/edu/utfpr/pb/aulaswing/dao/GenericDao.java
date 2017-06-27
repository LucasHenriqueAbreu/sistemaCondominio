package br.edu.utfpr.pb.aulaswing.dao;

import br.edu.utfpr.pb.aulaswing.db.DatabaseConnection;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class GenericDao <T, ID extends Serializable> {
    protected Class<T> persistedClass = getClazz();

    protected EntityManager em = DatabaseConnection.
            getInstance().getEntityManager();
    
    public GenericDao(){}
    //T = raw type
    public void insert(T entity) throws Exception{
        em.getTransaction().begin();
        try {
            em.persist( entity );
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception("Erro ao inserir registro!");
        }
    }
    
    public void update(T entity) throws Exception{
        em.getTransaction().begin();
        try {
            em.merge( entity );
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception("Erro ao atualizar registro!");
        }
    }
    
    public void remove(ID id) throws Exception{
        em.getTransaction().begin();
        try {
            em.remove( em.getReference(persistedClass, id) );
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new Exception("Erro ao remover registro!");
        }
    }
    
    public T findById(ID id){
        return em.find(persistedClass, id);
    }
    
    public List<T> findAll(){
        return em.createQuery("from " + 
                persistedClass.getName()).getResultList();
    }
    
    private Class<T> getClazz() {
        Class<?> clazz = this.getClass();
        while(!clazz.getSuperclass().equals(GenericDao.class)){
            clazz = clazz.getSuperclass();
        }
        ParameterizedType tipoGenerico = (ParameterizedType)
                clazz.getGenericSuperclass();
        return (Class<T>) 
                tipoGenerico.getActualTypeArguments()[0];
    }
    
    
}
