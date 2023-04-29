package co.edu.cue.jpa;

import co.edu.cue.jpa.model.Client;
import co.edu.cue.jpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateCreate {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String name = JOptionPane.showInputDialog("Input the name of the client: ");
            String lastname = JOptionPane.showInputDialog("Input the lastname of the client:");
            String payment = JOptionPane.showInputDialog("Input the payment method of the client:");
            em.getTransaction().begin();
            Client c = new Client();
            c.setName(name);
            c.setLastName(lastname);
            c.setMethodPayment(payment);
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("the id of the register client is " + c.getId());
            c = em.find(Client.class, c.getId());
            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
