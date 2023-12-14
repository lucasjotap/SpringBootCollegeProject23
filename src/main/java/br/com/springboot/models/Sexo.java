/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.springboot.models;

/**
 *
 * @author lucas
 */
public enum Sexo {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");
    
    private final String descricao;
    
    Sexo(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
