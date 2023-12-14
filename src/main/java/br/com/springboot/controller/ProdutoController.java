/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.controller;

import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot.bo.ProdutoBO;
import br.com.springboot.models.Produto;
import br.com.springboot.models.Categoria;
/**
 *
 * @author lucas
 */
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoBO prudutoBO;
    
    @RequestMapping(value = "/novo",  method = RequestMethod.GET)
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", Arrays.asList(Categoria.values()));
        return new ModelAndView("/produto/formulario", model);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String salva(@Valid @ModelAttribute Produto produto, BindingResult result, RedirectAttributes attr){
        if (result.hasErrors()){
            return "produto/formulario";
        }
        if (produto.getId() == null){
            prudutoBO.insere(produto);
            attr.addFlashAttribute("feedback", "Produto cadastrado com sucesso");
        }
        else{
            prudutoBO.atualiza(produto);
            attr.addFlashAttribute("feedback", "Produto atualizado com sucesso");
        }
            return "redirect:/produtos";
    }

    @RequestMapping(value = "",  method = RequestMethod.GET)
    public ModelAndView lista(ModelMap model) {
        model .addAttribute("produtos", prudutoBO.listaTodos());
        return new ModelAndView("/produto/lista", model);
    }

    @RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("produto", prudutoBO.pesquisaPeloId(id));
        return new  ModelAndView("/produto/formulario", model);
    }

    @RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
    public String inativa(@PathVariable("id") Long id, RedirectAttributes attr) {
        try {
                  Produto produto = prudutoBO.pesquisaPeloId(id);
                  prudutoBO.inativa(produto);
                  attr.addFlashAttribute("feedback", "Produto inativado com sucesso");
        } catch (Exception e) {
                  e.printStackTrace();
        }
        return "redirect:/produtos";
    }

    @RequestMapping(value="ativa/{id}", method=RequestMethod.GET)
    public String ativa(@PathVariable("id") Long id, RedirectAttributes attr){
        try{
                Produto produto = prudutoBO.pesquisaPeloId(id);
                prudutoBO.ativa(produto);
                attr.addFlashAttribute("feedback", "Produto ativado com sucesso");
        } catch (Exception e) {
                e.printStackTrace();
        }
        return "redirect:/produtos";
    }
    
}
