package br.ufscar.dc.dsw.ExcellentVoyage.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.ExcellentVoyage.domain.Agencia;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.PacoteTuristico;

@SuppressWarnings("unchecked")
public interface IPacoteTuristicoDAO extends CrudRepository<PacoteTuristico, Long>{

	PacoteTuristico findById(long id);

	List<PacoteTuristico> findAll();

	List<PacoteTuristico> findAllByAgencia(Agencia agencia);

	List<PacoteTuristico> findAllByAgenciaAndDataPartidaGreaterThan(Agencia agencia, Date currentDate);

    // @Query("SELECT p FROM pacote_turistico p, compra c WHERE p.id = c.id_pacote AND c.id_cliente = :idcliente")
	// List<PacoteTuristico> findAllByCliente(@Param("idcliente") Long idCliente);

	PacoteTuristico save(PacoteTuristico compra);
}