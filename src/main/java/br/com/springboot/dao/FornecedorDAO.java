/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.dao;

import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.springboot.models.Fornecedor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
@Transactional
public class FornecedorDAO implements CRUD<Fornecedor, Long>{
    
            @PersistenceContext
           private EntityManager entityManager;

           @Override
           public Fornecedor pesquisaPeloId(Long id){
                   return entityManager.find(Fornecedor.class, id);
           }

           @Override
           public List<Fornecedor> listaTodos() {
                   Query query = entityManager.createQuery("Select f from Fornecedor f");
                   return (List<Fornecedor>) query.getResultList();
           }

           @Override
           public void insere(Fornecedor fornecedor) {
                   entityManager.persist(fornecedor);
           }

           @Override
           public void atualiza(Fornecedor fornecedor) {
                   entityManager.merge(fornecedor);
           }

           @Override
           public void remove(Fornecedor fornecedor) {
                   entityManager.remove(fornecedor);
           }
     
}
