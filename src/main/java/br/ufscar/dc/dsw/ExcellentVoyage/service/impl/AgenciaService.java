package br.ufscar.dc.dsw.ExcellentVoyage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.ExcellentVoyage.dao.IAgenciaDAO;
import br.ufscar.dc.dsw.ExcellentVoyage.service.spec.IAgenciaService;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.Agencia;

@Service
@Transactional(readOnly = false)
public class AgenciaService implements IAgenciaService{

    @Autowired
    IAgenciaDAO dao;

    @Transactional(readOnly = true)
    public Agencia buscarPorId(Long id){
        return dao.findById(id.longValue());
    }

    @Transactional(readOnly = true)
    public List<Agencia> buscarTodos(){
        return dao.findAll();
    }

    public void salvar(Agencia agencia) {
        dao.save(agencia);
    }

    public void excluir(Long id){
        dao.deleteById(id);
    }
}
