package br.ufsc.dao;

public class GenericHibernateDao<E> implements Dao<E> {

    public void salvar(E e) {
        ConnectionManager.getEntityManager().getTransaction().begin();
        ConnectionManager.getEntityManager().persist(e);
        ConnectionManager.getEntityManager().getTransaction().commit();
    }

    public void update() {
        ConnectionManager.getEntityManager().getTransaction().begin();
        ConnectionManager.getEntityManager().getTransaction().commit();
    }

    public void excluir(E e) {
        System.out.println("Excluindo");
        ConnectionManager.getEntityManager().getTransaction().begin();
        ConnectionManager.getEntityManager().remove(e);
        ConnectionManager.getEntityManager().getTransaction().commit();
    }

}
