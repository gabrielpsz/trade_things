package br.ufsc.dao;

import br.ufsc.modelo.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDaoImp extends GenericHibernateDao<Usuario> implements UsuarioDao{

    private EntityManager manager;

    public UsuarioDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

    public List<Usuario> buscarTodos() {
        return null;
    }

    public List<Usuario> buscarPorCPF(String cpf) {
        return null;
    }

    public Usuario buscarPorId(Long idUsuario) {
        return null;
    }

    public Usuario autenticarUsuario(String login, String senha) {
        return null;
    }
}
