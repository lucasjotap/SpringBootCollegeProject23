/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.springboot.controller;

import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import br.com.springboot.bo.FornecedorBO;
import br.com.springboot.models.Fornecedor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/* @author lucas */

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    
            @Autowired
            private FornecedorBO bo;

            @RequestMapping(value = "/novo",  method = RequestMethod.GET)
            public ModelAndView novo(ModelMap model) {
                model .addAttribute("fornecedor", new Fornecedor());
                return new ModelAndView("/fornecedor/formulario", model);
            }

            @RequestMapping(value = "", method = RequestMethod.POST)
            public String salva(@Valid @ModelAttribute Fornecedor fornecedor, BindingResult result, RedirectAttributes attr){
                if (result.hasErrors()){
                    return "fornecedor/formulario";
                }
                if (fornecedor.getId() == null){
                    bo.insere(fornecedor);
                    attr.addFlashAttribute("feedback", "Fornecedor cadastrado com sucesso");
                }
                else{
                    bo.atualiza(fornecedor);
                    attr.addFlashAttribute("feedback", "Fornecedor atualizado com sucesso");
                }
                    return "redirect:/fornecedores";
            }

            @RequestMapping(value = "",  method = RequestMethod.GET)
            public ModelAndView lista(ModelMap model) {
                model .addAttribute("fornecedor", bo.listaTodos());
                return new ModelAndView("/fornecedor/lista", model);
            }

            @RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
            public ModelAndView edita(@PathVariable("id") Long id, ModelMap model){
                model.addAttribute("fornecedor", bo.pesquisaPeloId(id));
                return new  ModelAndView("/fornecedor/formulario", model);
            }

            @RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
            public String inativa(@PathVariable("id") Long id, RedirectAttributes attr) {
                try {
                          Fornecedor fornecedor = bo.pesquisaPeloId(id);
                          bo.inativa(fornecedor);
                          attr.addFlashAttribute("feedback", "Fornecedor inativado com sucesso");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "redirect:/fornecedores";
            }

            @RequestMapping(value="ativa/{id}", method=RequestMethod.GET)
            public String ativa(@PathVariable("id") Long id, RedirectAttributes attr){
                try{
                        Fornecedor fornecedor = bo.pesquisaPeloId(id);
                        bo.ativa(fornecedor);
                        attr.addFlashAttribute("feedback", "Fornecedor ativado com sucesso");
                } catch (Exception e) {
                          e.printStackTrace();
                }
                return "redirect:/fornecedores";
            }

}

