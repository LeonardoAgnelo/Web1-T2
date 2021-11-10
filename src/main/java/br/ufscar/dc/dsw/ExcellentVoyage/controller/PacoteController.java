package br.ufscar.dc.dsw.ExcellentVoyage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Foto;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.PacoteTuristico;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IPacoteService;

@Controller
@RequestMapping("/pacote")
public class PacoteController {
  @Autowired
  IPacoteService service;

  @Autowired
	ServletContext context;

  @GetMapping("/adicionar")
  public String formsPacote(
    PacoteTuristico pacoteTuristico
  ){
      return "adicionarPacote";
  }

  @PostMapping("/salvar")
  public String salvar(
    @Valid PacoteTuristico pacoteTuristico,
    BindingResult result,
    @RequestParam("descricaoFile") MultipartFile descricao,
    @RequestParam("fotosFile") MultipartFile[] fotos,
    Model model
  ) throws IOException {
    Boolean hasOtherErros = false;
    if (descricao.isEmpty()) {
      model.addAttribute("descricaoFile", "O campo descrição é obrigatorio.");
      hasOtherErros = true;
    }

    if (fotos.length > 10) {
      model.addAttribute("fotosFile", "Máximo de 10 fotos");
      hasOtherErros = true;
    } else if(fotos.length == 1 && fotos[0].isEmpty()) {
      model.addAttribute("fotosFile", "Mínimo de 1 foto");
      hasOtherErros = true;
    }

    if (result.hasErrors() || hasOtherErros) {
      model.addAttribute("result", result);
      return "adicionarPacote";
    }

    String descricaoDir = addFile(descricao);
    pacoteTuristico.setDescricao(descricaoDir);

    List<Foto> listaFotos = new ArrayList<Foto>();

    for(int i = 0; i < fotos.length; i++) {
      Foto foto = new Foto(addFile(fotos[i]));
      listaFotos.add(foto);
    }

    pacoteTuristico.setFotos(listaFotos);

    pacoteTuristico.setQtdFoto(listaFotos.size());

    service.salvar(pacoteTuristico);

    return "redirect:/perfil";
  }

  private String addFile(MultipartFile file) throws IOException {
    String fileName = file.getOriginalFilename().split("\\.")[0] + "-" + UUID.randomUUID().toString() + "." + file.getOriginalFilename().split("\\.")[1] ;

    String uploadPath = context.getRealPath("") + File.separator + "upload";
		File uploadDir = new File(uploadPath);
		
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		file.transferTo(new File(uploadDir, fileName));

    return uploadPath + fileName;
  }
}
