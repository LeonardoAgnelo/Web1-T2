package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Cliente;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    IClienteService service;

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("result", result);
            return "cadastroCliente";
        }

        cliente.setTipo("cliente");

        service.salvar(cliente);

        return "index";
    }
}
