package br.ufscar.dc.dsw.ExcellentVoyage.dao;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Compra;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.Cliente;

@SuppressWarnings("unchecked")
public interface ICompraDAO extends CrudRepository<Compra, Long>{
	
	Compra save(Compra compra);

    Compra findByIdClienteByIDPacote(Cliente u);
}