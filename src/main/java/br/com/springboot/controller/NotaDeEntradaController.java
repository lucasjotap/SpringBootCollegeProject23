/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.controller;

import javax.validation.Valid;
import br.com.springboot.bo.ProdutoBO;
import org.springframework.ui.ModelMap;
import br.com.springboot.bo.FornecedorBO;
import br.com.springboot.bo.NotaDeEntradaBO;
import br.com.springboot.models.NotaDeEntrada;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author lucas
 */

@Controller
@RequestMapping
public class NotaDeEntradaController {
    
    @Autowired
    private NotaDeEntradaBO notaEntradaBO;
    
    @Autowired
    private FornecedorBO fornecedorBO;
    
    @Autowired
    private ProdutoBO produtoBO;
    
    @RequestMapping(value="/novo", method=RequestMethod.GET)
    public ModelAndView novo(ModelMap model){
        model.addAttribute("notaEntrada", new NotaDeEntrada());
        model.addAttribute("fornecedores",  fornecedorBO.listaTodos());
        return new ModelAndView("/nota-entrada/formulario", model);
    }
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public String salva(@Valid @ModelAttribute NotaDeEntrada notaEntrada,
                                                        BindingResult result,
                                                        RedirectAttributes attr){
                      if (result.hasErrors()){
                          return "/nota-entrada/formulario";
                      }
                      if (notaEntrada.getId() == null){
                          notaEntradaBO.insere(notaEntrada);
                          attr.addFlashAttribute("feedback", "A nota de entrada foi cadastrada com sucesso");
                      } else {
                           notaEntradaBO.atualiza(notaEntrada);
                           attr.addFlashAttribute("feedback", "Os dados da nota de entrada foram atualizados com suceeso");
                      }
                      return "redirect:/nota-entrada";
    }
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView lista(ModelMap model){
        model.addAttribute("notas", notaEntradaBO.listaTodos());
        return new ModelAndView("/nota-entrada/lista", model);
    }
    
//    @RequestMapping(value="/{id}/item", method=RequestMethod.GET)
//    public ModelAndView produto(@PathVariable("id") Long id, ModelMap model){
//    }
//    
}
