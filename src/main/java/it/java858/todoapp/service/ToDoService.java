/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp.service;

import it.java858.todoapp.entity.ToDo;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class ToDoService {//qui mettiamo il codice necessario per lavorare con i toDo, solo con metodi 

    private ToDoService() {//costruttore privato = non crea istanza di questa classe
    }
    
    public static ToDo save(ToDo toSave){
        
        EntityManager em = DbService.getEm();
        em.getTransaction().begin();
        ToDo saved = em.merge(toSave);
        em.getTransaction().commit();
        return saved;
        
    }
    
    
}
