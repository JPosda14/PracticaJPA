package co.edu.cue.jpa;

import co.edu.cue.jpa.model.Client;
import co.edu.cue.jpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateList {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Client> clients = em.createQuery("select c from Client c", Client.class).getResultList(); // me convierte los datos de la base de datos en objetos brutal !!!!
        clients.forEach(System.out::println);
        em.close();
    }
}
