/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import br.com.springboot.models.Cliente;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository; 

/**
 *
 * @author lucas
 */
@Repository
public class ClienteDAO implements CRUD<Cliente,  Long>{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Cliente pesquisaPeloId(Long id){
            return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> listaTodos() {
            Query query = entityManager.createQuery("Select c from Cliente c");
            return (List<Cliente>) query.getResultList();
    }

    @Override
    public void insere(Cliente cliente) {
            entityManager.persist(cliente);
    }

    @Override
    public void atualiza(Cliente cliente) {
            entityManager.merge(cliente);
    }

    /**
     *
     * @param cliente
     */
    @Override
    public void remove(Cliente cliente) {
            entityManager.remove(cliente);
    }
    
}
