/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.bo;

import java.util.List;
import br.com.springboot.dao.CRUD;
import org.springframework.stereotype.Service;
import br.com.springboot.dao.NotaDeEntradaItemDAO;
import br.com.springboot.models.NotaDeEntradaItem;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucas
 */
@Service
public class NotaDeEntradaItemBO implements CRUD<NotaDeEntradaItem, Long> {

    @Autowired
    private NotaDeEntradaItemDAO notaDeEntradaDAO;
    
    @Override
    public NotaDeEntradaItem pesquisaPeloId(Long id) {
        return notaDeEntradaDAO.pesquisaPeloId(id);
    }

    @Override
    public void insere(NotaDeEntradaItem nota) {
        notaDeEntradaDAO.insere(nota);
    }

    @Override
    public List<NotaDeEntradaItem> listaTodos() {
        return notaDeEntradaDAO.listaTodos();
    }

    @Override
    public void atualiza(NotaDeEntradaItem nota) {
        notaDeEntradaDAO.atualiza(nota);
    }

    @Override
    public void remove(NotaDeEntradaItem nota) {
        notaDeEntradaDAO.remove(nota);
    }
    
}
