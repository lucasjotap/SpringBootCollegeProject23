/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 /**
 *
 * @author lucas
 */
@Controller
public class AplicacaoController {
    @RequestMapping(value={"/", ""}, method=RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login() {
        return "login";
    }
}
