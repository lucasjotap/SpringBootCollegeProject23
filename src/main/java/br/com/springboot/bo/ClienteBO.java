package br.com.springboot.bo;

import java.util.List;
import br.com.springboot.dao.CRUD;
import javax.transaction.Transactional;
import br.com.springboot.models.Cliente;
import br.com.springboot.dao.ClienteDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteBO implements CRUD<Cliente, Long>{
    @Autowired
    private ClienteDAO dao;
    
    @Transactional
    @Override
    public Cliente pesquisaPeloId(Long id){
           return dao.pesquisaPeloId(id);
    }
    
    @Transactional
    @Override
    public List<Cliente> listaTodos() {
            return dao.listaTodos();
    }

    @Transactional
    @Override
    public void insere(Cliente cliente) {
            dao.insere(cliente);
    }

    @Transactional
    @Override
    public void atualiza(Cliente cliente) {
            dao.atualiza(cliente);	
    }

    /**
     *
     * @param cliente
     */
    @Transactional
    @Override
    public void remove(Cliente cliente) {
        dao.remove(cliente);
    }
    
    @Transactional
    public void inativa(Cliente cliente) {
            cliente.setAtivo(false);
            dao.atualiza(cliente);
    }
    
    @Transactional
    public void ativa(Cliente cliente) {
            cliente.setAtivo(true);
            dao.atualiza(cliente);
    }

}