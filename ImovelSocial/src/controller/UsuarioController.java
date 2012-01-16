package controller;

import java.util.List;

import model.dao.UsuarioDAO;
import model.entity.Usuario;

public class UsuarioController {
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    public UsuarioController() {
        this.usuario = new Usuario();
        this.buscarUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String cadastrar() {
        boolean resultado = new UsuarioDAO().insert(usuario);
        if (resultado) {
            return "sucesso";
        } else {
            return "fail";
        }
    }
    
    public String buscarPorId() {
        this.usuario = new UsuarioDAO().selectById(usuario.getId());
        if (usuario != null) {
            return "cadastroUsuario";
        } else {
            return "fail";
        }
    }
    /*
    public String buscarPorNome() {
        this.usuarios = new UsuarioDAO().selectByNome(usuario.getNome());
        if (usuarios != null && !usuarios.isEmpty()) {
            return "listaUsuarios";
        } else if (usuarios.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    */
    public String buscarUsuarios() {
        this.usuarios = new UsuarioDAO().selectAll();
        if (usuarios != null && !usuarios.isEmpty()) {
            return "listaUsuarios";
        } else if (usuarios.isEmpty()) {
            return "fail";
        } else {
            return "fail";
        }
    }
    
}
