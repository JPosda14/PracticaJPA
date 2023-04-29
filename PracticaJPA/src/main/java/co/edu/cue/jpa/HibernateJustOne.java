package co.edu.cue.jpa;

import co.edu.cue.jpa.model.Client;
import co.edu.cue.jpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;
import java.util.List;

public class HibernateJustOne {
    public static void main(String[] args){
        String payment= JOptionPane.showInputDialog("Input your payment method");
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Client c where c.methodPayment=?1", Client.class);
        query.setParameter(1, payment);
        query.setMaxResults(1);
        List<Client> clientes = query.getResultList();
        System.out.println(clientes);
        em.close();
    }
}
