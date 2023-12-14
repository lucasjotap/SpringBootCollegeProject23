/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.bo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import br.com.springboot.models.Produto;
import org.junit.jupiter.api.MethodOrderer;
import br.com.springboot.models.Categoria;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
/**
 *
 * @author lucas
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdutoBOTest {
    
    @Autowired
    public ProdutoBO bo;
    
    @Test
    @Order(1)
    public void insere(){
        Produto produto = new Produto();
        produto.setNome("Laptop");
        produto.setCategoria(Categoria.INFORMATICA);
        produto.isAtivo();
        bo.insere(produto);
    }
    
    @Test
    @Order(2)
    public void pesquisaPeloId(){
        Produto produto = bo.pesquisaPeloId(1L);
//        System.out.printf("Produto: %s", produto);
        System.out.print( produto);
    }
    
    @Test
    @Order(3)
    public void atualiza(){
            Produto produto = bo.pesquisaPeloId(1L);
            System.out.println(produto);
            produto.setNome("MacBook");
            bo.atualiza(produto);	
    }
    
}
