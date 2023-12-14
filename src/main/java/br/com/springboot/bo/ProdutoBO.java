/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.bo;

import java.util.List;
import br.com.springboot.dao.CRUD;
import br.com.springboot.models.Produto;
import br.com.springboot.dao.ProdutoDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucas
 */
@Service
public class ProdutoBO implements CRUD<Produto, Long> {
    
    @Autowired
    private ProdutoDAO dao;
        
    @Override
    public Produto pesquisaPeloId(Long id) {
        return dao.pesquisaPeloId(id);
    }
    
    @Override
    public void insere(Produto produto) {
         dao.insere(produto);
    }
    
    @Override
    public List<Produto> listaTodos() {
       return dao.listaTodos();
    }
    
    @Override
    public void atualiza(Produto produto) {
         dao.atualiza(produto);
    }
    
    @Override
    public void remove(Produto produto) {
        dao.remove(produto);
    }
    
    public void ativa(Produto produto){
        produto.isAtivo();
        dao.atualiza(produto);
    }
   
    public void inativa(Produto produto){
        produto.setInativo(false);
        dao.atualiza(produto);
    }
    
}
