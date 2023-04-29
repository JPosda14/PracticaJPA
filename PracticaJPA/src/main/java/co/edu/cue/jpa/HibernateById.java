package co.edu.cue.jpa;

import co.edu.cue.jpa.model.Client;
import co.edu.cue.jpa.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateById {
    public static void main(String[] args) {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Input the id of the client"));
        EntityManager em = JpaUtil.getEntityManager();
        Client cliente = em.find(Client.class, id);
        System.out.println(cliente);
        em.close();
    }
}
