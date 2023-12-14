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
import org.springframework.stereotype.Repository;
import br.com.springboot.models.NotaDeEntradaItem;

/**
 *
 * @author lucas
 */
@Repository
@Transactional
public class NotaDeEntradaItemDAO implements CRUD<NotaDeEntradaItem, Long>{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public NotaDeEntradaItem pesquisaPeloId(Long id){
        return entityManager.find(NotaDeEntradaItem.class, id);
    }
    
    @Override
    public void insere(NotaDeEntradaItem notaDeEntradaItem){
        entityManager.persist(notaDeEntradaItem);
    }
    
    @Override
    public void atualiza(NotaDeEntradaItem notaDeEntradaItem){
        entityManager.merge(notaDeEntradaItem);
    }
    
    @Override
    public void remove(NotaDeEntradaItem notaDeEntradaItem){
        entityManager.remove(notaDeEntradaItem);
    }
    
    @Override
    public List<NotaDeEntradaItem> listaTodos(){
        Query query = entityManager.createNamedQuery("select nei from NotaEntradaItem nei");
        return query.getResultList();
    }
    
    public List<NotaDeEntradaItem> listaItensNota(Long notaEntradaId) {
            Query query = entityManager.createQuery("from NotaDeEntradaItem n where n.notaEntrada.id = :notaEntradaId")
                                            .setParameter("notaEntradaId", notaEntradaId);
            return query.getResultList();
    }

}
