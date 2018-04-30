package br.ufsc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManager {

    private static EntityManagerFactory factory;
    private static EntityManager em;

    public static EntityManager getEntityManager() {
        if (em == null) {
            factory = Persistence.createEntityManagerFactory("trabalho_dsoii");
            em = factory.createEntityManager();
        }
        return em;
    }

    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
            factory.close();
        }
    }

}