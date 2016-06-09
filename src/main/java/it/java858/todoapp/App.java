/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp;

import it.java858.todoapp.entity.ToDo;
import it.java858.todoapp.gui.Main;
import it.java858.todoapp.service.DbService;
import it.java858.todoapp.service.ToDoService;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
        
        //System.out.println("Start jpa ..");
        
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        //EntityManager em = emf.createEntityManager();
        //EntityManager em = DbService.getEm();
        
        //System.out.println("jpa ok ..");
        
        //ToDo td = new ToDo();
        //td.setTesto("caffè tra poco ...");
        //td.setDataCreazione(new Date());
        
        //em.getTransaction().begin();
        //em.persist(td);
        //em.getTransaction().commit();
        
        //em.close();
        
        //ToDoService.save(td);
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
    });

    }
}
    
