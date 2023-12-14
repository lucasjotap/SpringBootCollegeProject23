/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.dao;

import br.com.springboot.models.NotaDeEntrada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
@Transactional
public class NotaDeEntradaDAO implements CRUD<NotaDeEntrada, Long>{
        
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public NotaDeEntrada pesquisaPeloId(Long id){
        return entityManager.find(NotaDeEntrada.class, id);
    }
    
    @Override
    public List<NotaDeEntrada> listaTodos(){
        Query query = entityManager.createQuery("select ne from NotaDeEntrada ne");
        return query.getResultList();
    }
    
    @Override
    public void insere(NotaDeEntrada notaDeEntrada){
        entityManager.persist(notaDeEntrada);
    }
    
    @Override
    public void atualiza(NotaDeEntrada notaDeEntrada){
        entityManager.merge(notaDeEntrada);
    }
    
    @Override
    public void remove(NotaDeEntrada notaDeEntrada){
        entityManager.remove(notaDeEntrada);
    }
    
}
