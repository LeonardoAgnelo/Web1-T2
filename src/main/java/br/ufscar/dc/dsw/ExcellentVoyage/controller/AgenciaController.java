package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/salvar")
    public String salvar(@Valid Agencia agencia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("result", result);
            return "cadastroAgencia";
        }

        agencia.setTipo("agencia");

        service.salvar(agencia);

        return "index";
    }
}