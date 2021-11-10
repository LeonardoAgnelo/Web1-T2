package br.ufscar.dc.dsw.ExcellentVoyage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.ExcellentVoyage.dao.IFotoDAO;
import br.ufscar.dc.dsw.ExcellentVoyage.dao.IPacoteTuristicoDAO;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.Foto;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.PacoteTuristico;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IPacoteService;

@Service
@Transactional(readOnly = false)
public class PacoteService implements IPacoteService {
  @Autowired
  IPacoteTuristicoDAO pacoteDAO;

  @Autowired
  IFotoDAO fotoDAO;

  @Override
  public void salvar(PacoteTuristico pacoteTuristico) {
    PacoteTuristico p = pacoteDAO.save(pacoteTuristico);

    for (Foto foto : pacoteTuristico.getFotos()) {
      foto.setPacoteTuristico(p);
    }

    for (Foto foto : pacoteTuristico.getFotos()) {
      fotoDAO.save(foto);
    }
  }
}
