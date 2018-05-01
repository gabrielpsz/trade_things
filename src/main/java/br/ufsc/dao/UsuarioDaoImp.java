package br.ufsc.dao;

import br.ufsc.modelo.Usuario;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDaoImp extends GenericHibernateDao<Usuario> implements UsuarioDao{

    private EntityManager manager;

    public UsuarioDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

    public List<Usuario> buscarTodos() {
    	Query query = manager.createNamedQuery("Usuario.buscarTodos");
		return query.getResultList();
    }

    public Usuario buscarPorId(Long id) {
    	return manager.find(Usuario.class, id);
    }

    public Usuario autenticarUsuario(String login, String senha) {
    	Query query = manager.createNamedQuery("Usuario.buscarPorEmailSenha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult();
    }
}
