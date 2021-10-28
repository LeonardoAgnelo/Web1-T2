package br.ufscar.dc.dsw.ExcellentVoyage.service.spec;


import br.ufscar.dc.dsw.ExcellentVoyage.domain.Usuario;

public interface IUsuarioService {
    
    public Usuario BuscarPorEmail(String email);
}
