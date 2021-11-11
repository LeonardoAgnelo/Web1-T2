package br.ufscar.dc.dsw.ExcellentVoyage.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.ExcellentVoyage.dao.IClienteDAO;
import br.ufscar.dc.dsw.ExcellentVoyage.domain.Cliente;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String>{

    @Autowired
	private IClienteDAO dao;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
        if(dao != null){
            Cliente cliente = dao.findByCpf(email);
            return cliente == null;
        }else{
            return true;
        }
    }
    
}
