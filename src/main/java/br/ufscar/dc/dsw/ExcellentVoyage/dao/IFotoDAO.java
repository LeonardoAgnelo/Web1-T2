package br.ufscar.dc.dsw.ExcellentVoyage.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Foto;

@SuppressWarnings("unchecked")
public interface IFotoDAO extends CrudRepository<Foto, Long> {
    Foto save(Foto foto);

    List<Foto> findAllByIdPacote(String idPacote);
}
