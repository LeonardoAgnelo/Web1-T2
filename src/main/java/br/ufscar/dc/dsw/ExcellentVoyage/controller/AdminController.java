package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IUsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    IUsuarioService service;


    @GetMapping("/home")
    public String home(Model model){


        return "admin/home";
    }
}
