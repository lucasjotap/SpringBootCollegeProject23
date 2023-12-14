/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.com.springboot.models;

/* @author lucas*/
public enum Categoria {
    
        CELULARES("Celulares"),
        ELETRODOMESTICO("Eletrodomesticos"),
        INFORMATICA("Informatica"),
        MOVEIS("Moveis");

        private final String descricao;
        
        Categoria(String descricao){
           this.descricao = descricao;
        }
        
        public String getDescricao(){
          return this.descricao;
      }
}
