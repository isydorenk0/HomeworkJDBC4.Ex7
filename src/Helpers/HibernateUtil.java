package Helpers;

import org.hibernate.HibernateError;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("jdbc4ex7");
            em = emf.createEntityManager();
        } catch (HibernateError e) {
            e.printStackTrace();
        }
    }

    public static EntityManager getEntityManager() { return em; }
    public static void closeEmf() { emf.close(); }

}
