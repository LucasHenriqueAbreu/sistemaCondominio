package br.edu.utfpr.pb.aulaswing.controller;

import br.edu.utfpr.pb.aulaswing.dao.ContaDao;
import br.edu.utfpr.pb.aulaswing.model.Conta;
import java.util.List;

/**
 *
 * @author Lucas Henrique de Abreu
 */
public class ContaController {
     private ContaDao contaDao;
    
    public ContaController(){
        contaDao = new ContaDao();
    }
    
    public List<Conta> listar(){
        return contaDao.findAll();
    }
    
    public void salvar(Conta conta) throws Exception {
        if ( conta.getId() != null ){
            contaDao.update(conta);
        }else{
            contaDao.insert(conta);
        }
    }

    public Conta buscar(Long id) {
        return contaDao.findById(id);
    }

    public void remover(Long id) throws Exception {
        contaDao.remove(id);
    }
}
