package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Agencia;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IAgenciaService;

@Controller
@RequestMapping("/agencia")
public class AgenciaController {

    @Autowired
    IAgenciaService service;

    @Autowired
	private BCryptPasswordEncoder encoder;

    @PostMapping("/salvar")
    public String salvar(@Valid Agencia agencia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("result", result);
            return "cadastroAgencia";
        }

        agencia.setSenha(encoder.encode(agencia.getSenha()));
        agencia.setTipo("ROLE_agencia");

        service.salvar(agencia);

        return "index";
    }
}
