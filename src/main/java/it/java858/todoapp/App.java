/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp;

import it.java858.todoapp.entity.ToDo;
import it.java858.todoapp.entity.ToDo_;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Start JPA...........");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        //EntityManager  em = emf.createEntityManager(); OPPURE:
        
        EntityManager  em = DbService.getEm();
        
        System.out.println("JPA ok...........");
        
        //inserimento record....
        ToDo td = new ToDo();
        td.setTesto("tra poco a casa maybe...");
        td.setDataCreazione(new Date());
        
       /* em.getTransaction().begin();
        em.persist(td);//fa la insert
        em.getTransaction().commit();//.merge = update record
        em.close();*/
        
        ToDoService.save(td);
       
    }
    
}
