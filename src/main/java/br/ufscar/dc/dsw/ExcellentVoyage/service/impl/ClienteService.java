package br.ufscar.dc.dsw.ExcellentVoyage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.ExcellentVoyage.dao.IClienteDAO;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.Cliente;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteService implements IClienteService {
    @Autowired
    IClienteDAO dao;

    public void salvar(Cliente cliente) {
        dao.save(cliente);
    }
}
