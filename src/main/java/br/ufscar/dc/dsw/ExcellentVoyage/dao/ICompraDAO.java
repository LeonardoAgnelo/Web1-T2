package br.ufscar.dc.dsw.ExcellentVoyage.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Compra;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.Cliente;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.Pacote;

@SuppressWarnings("unchecked")
public interface ICompraDAO extends CrudRepository<Compra, Long>{
	
	Compra save(Compra compra);

    Compra findByIDClienteByIDPacote(Cliente u);
}