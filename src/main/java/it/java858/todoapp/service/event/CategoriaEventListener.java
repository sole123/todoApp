/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp.service.event;

import it.java858.todoapp.entity.Categoria;

/**
 * definisce come deve essere fatto un ascoltatore di eventi CategoriaEvent
 * @author tss
 */

public interface CategoriaEventListener {

    public void onCreate(Categoria c);
    public void onUpdate(Categoria c);
    public void onDelete(Categoria c);
    
}
