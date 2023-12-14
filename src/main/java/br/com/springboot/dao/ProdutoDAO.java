/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.dao;

import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import br.com.springboot.models.Produto;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**** @author lucas*/
@Repository
@Transactional
public class ProdutoDAO implements CRUD<Produto, Long>{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Produto pesquisaPeloId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    public List<Produto> listaTodos() {
        Query query = entityManager.createQuery("select p from Produto p");
        return query.getResultList();
    }

    @Override
    public void insere(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    public void atualiza(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    public void remove(Produto produto) {
        entityManager.remove(produto);
    }
    
}
