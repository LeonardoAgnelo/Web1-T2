package br.ufscar.dc.dsw.ExcellentVoyage.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Agencia;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.PacoteTuristico;

public interface IPacoteService {
  void salvar(PacoteTuristico pacoteTuristico);

  List<PacoteTuristico> listarPelaAgencia(Agencia agencia);
}
