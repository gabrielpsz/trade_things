package br.ufsc.dao;

import br.ufsc.modelo.Produto;
import br.ufsc.modelo.Usuario;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDaoImp extends GenericHibernateDao<Produto> implements ProdutoDao {

    private EntityManager manager;

    public ProdutoDaoImp() {
        manager = ConnectionManager.getEntityManager();
    }

}
