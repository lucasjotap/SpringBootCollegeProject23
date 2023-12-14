/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.models;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

/**** @author lucas*/
@Entity
@Table(name="produtos")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Informe nome")
    @NotBlank(message="Informe categoria")
    @Column(nullable=false, length=50)
    private String nome;
    
    @NotNull(message="Informe categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    private boolean ativo;
    
    public  Produto(){
        this.ativo = true;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setInativo(boolean booleano) {
        this.ativo=booleano;
    }
    
}

