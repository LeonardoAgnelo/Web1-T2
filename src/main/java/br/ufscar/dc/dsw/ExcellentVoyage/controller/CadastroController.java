package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    
    @GetMapping("")
    public String cadastro(){
        return "cadastro";
    }

    @GetMapping("/agencia")
    public String cadastroAgencia(){
        return "cadastroAgencia";
    }

    @GetMapping("/cliente")
    public String cadastroCliente(){
        return "cadastroCliente";
    }

}
