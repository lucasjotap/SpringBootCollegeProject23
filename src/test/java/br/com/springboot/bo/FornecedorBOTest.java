/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.bo;

import br.com.springboot.models.Fornecedor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author lucas
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FornecedorBOTest {

            @Autowired
            private FornecedorBO bo;
            
            @Test
            @Order(1)
            public void insere(){
                      Fornecedor fornecedor = new Fornecedor();
                      fornecedor.setNomeFantasia("Random");
                      fornecedor.setRazaoSocial("1234567811");
                      fornecedor.setTelefone("1234567891");
                      fornecedor.setCelular("12345678911");
                      fornecedor.setAtivo(true);
                      bo.insere(fornecedor);
            }

            @Test
            @Order(2)
            public void pesquisaPeloId(){
                        Fornecedor fornecedor = bo.pesquisaPeloId(1L);
                        System.out.println(fornecedor);	
            }
            
            @Test
            @Order(3)
            public void atualiza(){
                        Fornecedor fornecedor = bo.pesquisaPeloId(1L);
                        fornecedor.setRazaoSocial("12332112321");
                        bo.atualiza(fornecedor);	
            }
}
