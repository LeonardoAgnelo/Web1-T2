package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Usuario;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IUsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    IUsuarioService service;

    @Autowired
	private BCryptPasswordEncoder encoder;

    @GetMapping("/home")
    public String home(Model model){
        

        return "admin/home";
    }
}
