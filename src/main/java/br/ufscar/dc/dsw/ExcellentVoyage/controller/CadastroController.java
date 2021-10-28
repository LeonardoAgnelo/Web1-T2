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
    public String formsAgencia(){
        return "cadastroAgencia";
    }

    @GetMapping("/cliente")
    public String formsCliente(){
        return "cadastroCliente";
    }

    @GetMapping("/cadastroAgencia")
    public String cadastrarAgencia(){
        //implementar cadastro de agencia

        return "index";
    }

    @GetMapping("/cadastroCliente")
    public String cadastrarCliente(){
        //implementar cadastro de cliente
        
        return "index";
    }

}
