package com.controladores.usuarios;


import com.modelo.dao.UsuarioFacade;
import com.modelo.entidades.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Andres
 */
@Named(value = "controladorRegistrarUsuarios")
@ViewScoped
public class ControladorRegistrarUsuarios implements Serializable{

    @EJB
    private UsuarioFacade usuarioFacade;
    
    private Usuario usuario;
    
    
    public ControladorRegistrarUsuarios() {
        
    }
    
    @PostConstruct
    
    public void init(){
        
        usuario = new Usuario();
    }
    
    public String registrarUsuario(){
        
        usuarioFacade.create(usuario);
        
        return "listarUsuarios.xhtml";
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
