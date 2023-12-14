/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.springboot.dao;

import java.util.List;

/**
 *
 * @author lucas
 * @param <T>
 * @param <ID>
 */
public interface CRUD<T, ID> {
    T pesquisaPeloId(ID id);
    //Create
    void insere(T t);
    //Read
    List<T> listaTodos();
    //Update
    void atualiza(T t);
    //Delete
    void remove(T t);
}
