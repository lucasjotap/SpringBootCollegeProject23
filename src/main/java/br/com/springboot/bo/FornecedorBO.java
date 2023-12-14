/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.bo;

import java.util.List;
import br.com.springboot.dao.CRUD;
import br.com.springboot.models.Fornecedor;
import br.com.springboot.dao.FornecedorDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author lucas
 */
@Service
public class FornecedorBO implements CRUD<Fornecedor, Long>{
    
    @Autowired
    private FornecedorDAO dao;
    
    @Override
    public Fornecedor pesquisaPeloId(Long id){
           return dao.pesquisaPeloId(id);
    }
    
    @Override
    public List<Fornecedor> listaTodos() {
            return dao.listaTodos();
    }

    @Override
    public void insere(Fornecedor fornecedor) {
            dao.insere(fornecedor);
    }

    @Override
    public void atualiza(Fornecedor fornecedor) {
            dao.atualiza(fornecedor);	
    }

    @Override
    public void remove(Fornecedor fornecedor) {
        dao.remove(fornecedor);
    }
    
    public void inativa(Fornecedor fornecedor) {
            fornecedor.setAtivo(false);
            dao.atualiza(fornecedor);
    }
    
    public void ativa(Fornecedor fornecedor) {
            fornecedor.setAtivo(true);
            dao.atualiza(fornecedor);
    }
    
}
