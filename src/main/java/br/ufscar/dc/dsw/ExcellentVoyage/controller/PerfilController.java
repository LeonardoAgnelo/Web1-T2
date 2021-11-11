package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Agencia;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.PacoteTuristico;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IPacoteService;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IUsuarioService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
  @Autowired
  IPacoteService pacoteService;

  @Autowired
  IUsuarioService usuarioService;
  
  @GetMapping("")
  public String onLoad(@RequestParam(name = "vigente", required = false) String vigente, Authentication auth, Model model) {
      String role = auth.getAuthorities().toArray()[0].toString();
  
      switch (role) {
        case "ROLE_agencia":
            if (vigente != null) {
              System.out.println("opa: " + vigente);
            }
            Agencia agencia = (Agencia) usuarioService.buscarPorEmail(auth.getName());
            List<PacoteTuristico> listaPacotes = pacoteService.listarPelaAgencia(agencia, Boolean.valueOf(vigente));
            model.addAttribute("listaPacotes", listaPacotes);
          break;
      
        default:
          break;
      }

      return "perfil";
  }
}
