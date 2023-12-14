package br.com.springboot.bo;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import br.com.springboot.models.Sexo;
import br.com.springboot.models.Cliente;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ClienteBOTest {

    @Autowired
    private ClienteBO bo;

    @Test
    @Order(1)
    public void insere(){
                            Cliente cliente = new Cliente();
                            cliente.setNome("Random");
                            cliente.setCpf("1234567811");
                            cliente.setDataDeNascimento(LocalDate.of(2000, 1, 8));
                            cliente.setSexo(Sexo.MASCULINO);
                            cliente.setTelefone("1234567891");
                            cliente.setCelular("123456789111");
                            cliente.setAtivo(true);
                            bo.insere(cliente);
    }

    @Test
    @Order(2)
    public void pesquisaPeloId(){
                            Cliente cliente = bo.pesquisaPeloId(1L);
                            System.out.println(cliente);	
    }

    @Test
    @Order(3)
    public void atualiza(){
                            Cliente cliente = bo.pesquisaPeloId(1L);
                            cliente.setCpf("12332112321");
                            bo.atualiza(cliente);	
    }
}