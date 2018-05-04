package com.controladores.usuarios;

import com.modelo.dao.UsuarioFacade;
import com.modelo.entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Andres
 */
@Named(value = "controladorListarUsuarios")
@ViewScoped
public class ControladorListarUsuarios implements Serializable{

    @EJB
    
    private UsuarioFacade usuarioFacade;
    
    private List<Usuario> listaUsuarios;

    public ControladorListarUsuarios() {
    }
    
    @PostConstruct
    
    public void init(){
        
        listaUsuarios = usuarioFacade.findAll();
    
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    
}
