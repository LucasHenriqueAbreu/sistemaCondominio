package br.edu.utfpr.pb.aulaswing.controller;

import br.edu.utfpr.pb.aulaswing.dao.UsuarioDao;
import br.edu.utfpr.pb.aulaswing.model.Usuario;
import java.util.List;

public class UsuarioController {
    private UsuarioDao usuarioDao;
    
    public UsuarioController(){
        usuarioDao = new UsuarioDao();
    }
    
    public List<Usuario> listar(){
        return usuarioDao.findAll();
    }
    
    public void salvar(Usuario usuario) throws Exception {
        if ( usuario.getId() != null ){
            usuarioDao.update(usuario);
        }else{
            usuarioDao.insert(usuario);
        }
    }

    public Usuario buscar(Long id) {
        return usuarioDao.findById(id);
    }

    public void remover(Long id) throws Exception {
        usuarioDao.remove(id);
    }

    public Usuario validarUsuario(String email, String senha) {
        return usuarioDao.findByEmailAndSenha(email, senha);
    }
}
