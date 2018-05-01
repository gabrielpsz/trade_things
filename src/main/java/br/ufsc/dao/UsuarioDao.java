package br.ufsc.dao;

import br.ufsc.modelo.Usuario;

import java.util.List;


public interface UsuarioDao extends Dao<Usuario>{

    List<Usuario> buscarTodos();
    Usuario buscarPorId(Long id);
    Usuario autenticarUsuario(String login, String senha);

}
