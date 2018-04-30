package br.ufsc.dao;

import br.ufsc.modelo.Usuario;

import java.util.List;


public interface UsuarioDao extends Dao<Usuario>{

    List<Usuario> buscarTodos();
    List<Usuario> buscarPorCPF(String cpf);
    Usuario buscarPorId(Long idUsuario);
    Usuario autenticarUsuario(String login, String senha);

}
