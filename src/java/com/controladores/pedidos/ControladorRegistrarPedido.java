package com.controladores.pedidos;

import com.modelo.dao.PedidoFacade;
import com.modelo.dao.UsuarioFacade;
import com.modelo.entidades.Pedido;
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
@Named(value = "controladorRegistrarPedido")
@ViewScoped
public class ControladorRegistrarPedido implements Serializable {

    @EJB
    private PedidoFacade pedidoFacade;
    
    private Pedido pedido;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private List <Usuario> listaUsuarios;
    
    public ControladorRegistrarPedido() {
    }
    
    @PostConstruct
    
    public void init(){
        
        pedido = new Pedido();
        
        listaUsuarios = usuarioFacade.findAll();
    }
    
    public String registrarPedido(){
        
        pedidoFacade.create(pedido);
        
        return"registrarListarPedidos.xhtml?faces-redirect=true";
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    
    
    
}
