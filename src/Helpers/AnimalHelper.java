package Helpers;

import Entity.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AnimalHelper {

    EntityManager em;

    public AnimalHelper() {
        this.em = HibernateUtil.getEntityManager();
    }

    public void closeConnection(){
       HibernateUtil.closeEmf();
    }

    public Animal getAnimalById(long id) {
        if(!em.getTransaction().isActive()) em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        return animal;
    }

    public void delAnimal(Animal animal) {
        if(!em.getTransaction().isActive()) em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
    }

    public void addAnimal(Animal animal) {
        if(!em.getTransaction().isActive()) em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
    }

    public List<Animal> getAnimalList() {
        if(!em.getTransaction().isActive()) em.getTransaction().begin();
        Query q = em.createQuery("from Entity.Animal");
        List<Animal> animalList = q.getResultList();
        return animalList;
    }
}
