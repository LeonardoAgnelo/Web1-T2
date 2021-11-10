package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
  public String onLoad(Authentication auth, Model model) {
      String role = auth.getAuthorities().toArray()[0].toString();
  
      switch (role) {
        case "ROLE_agencia":
            Agencia agencia = (Agencia) usuarioService.buscarPorEmail(auth.getName());
            List<PacoteTuristico> listaPacotes = pacoteService.listarPelaAgencia(agencia);
            System.out.println(listaPacotes.size());
            model.addAttribute("listaPacotes", listaPacotes);
          break;
      
        default:
          break;
      }

      return "perfil";
  }
}
