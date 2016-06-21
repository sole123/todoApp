/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp.service;

import it.java858.todoapp.entity.Categoria;
import it.java858.todoapp.service.event.CategoriaEventListener;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tss
 */
public class CategoriaService {
    
    private CategoriaService() {
    }
    
    private static List<CategoriaEventListener> listeners = new ArrayList<>();

    /**
     * aggiunge ascoltatore alla lista
     *
     * @param listener
     */
    public static void addCategoriaEventListener(CategoriaEventListener listener) {
        
        listeners.add(listener);
    }
    
    public static Categoria save(Categoria c) {
        EntityManager em = DbService.getEm();
        em.getTransaction().begin();
        Categoria saved = em.merge(c);
        em.getTransaction().commit();
        for (CategoriaEventListener listener : listeners) {
            if (c.getId() == null) {
                listener.onCreate(saved);
            } else {
                listener.onUpdate(saved);
            }
        }
        return saved;
    }
    
    public static void elimina(Categoria c) {
        EntityManager em = DbService.getEm();
        em.getTransaction().begin();
        Categoria find = em.find(Categoria.class, c.getId());
        em.remove(c);
        em.getTransaction().commit();
        //Richiama il metodo onElimina su tutti gli ascoltatori iscritti
        for (CategoriaEventListener listener : listeners) {
            listener.onDelete(c);
        }
        
    }
    
    public static List<Categoria> findAll() {
        EntityManager em = DbService.getEm();
        List<Categoria> listcat;
        listcat = em.createQuery("select c from Categoria c order by c.nome", Categoria.class).getResultList();
        return listcat;
    }
    
}
