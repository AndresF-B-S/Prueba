package com.controladores.usuarios;

import com.modelo.dao.UsuarioFacade;
import com.modelo.entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author Andres
 */
@Named(value = "controladorEditarUsuarios")
@ConversationScoped
public class ControladorEditarUsuarios implements Serializable {

    @EJB

    private UsuarioFacade ususariofacade;

    private Usuario usuarioEdit;

    @Inject

    private Conversation conversacion;

    public ControladorEditarUsuarios() {
    }

    public void iniciarConversacion() {

        if (conversacion.isTransient()) {

            conversacion.begin();
        }
    }
    
    public void terminarconversacion(){
        
        if (!conversacion.isTransient()) {
            
            conversacion.end();
        }
    }
    
    public String cancelar(){
        
        terminarconversacion();
        
        return"listarUsuarios.xhtml";
    }
    
    public String editar(){
        
        ususariofacade.edit(usuarioEdit);
        
        return cancelar();
    
    }
    
    public String prepararEditar(Usuario usuario){
        iniciarConversacion();
        this.usuarioEdit = usuario;
        return"editarUsuarios.xhtml";
    }

    public Usuario getUsuarioEdit() {
        return usuarioEdit;
    }

    public void setUsuarioEdit(Usuario usuarioEdit) {
        this.usuarioEdit = usuarioEdit;
    }
    
    
}
