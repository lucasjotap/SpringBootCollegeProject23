/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.bo;

import br.com.springboot.dao.CRUD;
import br.com.springboot.dao.NotaDeEntradaDAO;
import br.com.springboot.models.NotaDeEntrada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class NotaDeEntradaBO implements CRUD<NotaDeEntrada, Long>{
    
    @Autowired
    private NotaDeEntradaDAO notaDeEntradaDAO;
    
    @Override
    public List<NotaDeEntrada> listaTodos(){
        return notaDeEntradaDAO.listaTodos();
    }
    
    @Override
    public void insere(NotaDeEntrada notaDeEntrada){
         notaDeEntradaDAO.insere(notaDeEntrada);
    }
    
    @Override
    public void atualiza(NotaDeEntrada notaDeEntrada){
         notaDeEntradaDAO.atualiza(notaDeEntrada);
    }
    
    @Override
    public void remove(NotaDeEntrada notaDeEntrada){
         notaDeEntradaDAO.remove(notaDeEntrada);
    }

    @Override
    public NotaDeEntrada pesquisaPeloId(Long id) {
         return notaDeEntradaDAO.pesquisaPeloId(id);
    }
    
}
