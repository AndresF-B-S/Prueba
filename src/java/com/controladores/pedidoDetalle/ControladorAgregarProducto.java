package com.controladores.pedidoDetalle;

import com.modelo.dao.PedidoDetalleFacade;
import com.modelo.dao.PedidoFacade;
import com.modelo.entidades.Pedido;
import com.modelo.entidades.PedidoDetalle;
import javax.inject.Named;
import javax.enterprise.context.ConversationScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

/**
 *
 * @author Andres
 */
@Named(value = "controladorAgregarProducto")
@ConversationScoped
public class ControladorAgregarProducto implements Serializable {

    @EJB
    private PedidoDetalleFacade pedidoDetalleFacade;
    
    private PedidoDetalle pedidoDetalle; 
    
    private List<PedidoDetalle> listaDetallePedido;
    
    @EJB
    private PedidoFacade pedidoFacade;
    
    private Pedido pedidoSeleccionado;
    
    @Inject
    
    private Conversation conversacion;
    
  
    public ControladorAgregarProducto() {
    }
    
    @PostConstruct
    
    public void init(){
        
        pedidoDetalle = new PedidoDetalle();
        
        listaDetallePedido = pedidoDetalleFacade.findAll();
    
    }
    
    public void iniciarConversacion(){
        
        if (conversacion.isTransient()) {
            
            conversacion.begin();
            
        }
    }
    
    public void terminarConversacion(){
        if (!conversacion.isTransient()) {
            
            conversacion.end();
            
        }
    }
    
    public String cancelar(){
        terminarConversacion();
        
        return "registrarListarPedidos.xhtml";
    }
    
    public String agregarProducto(){
    
        pedidoDetalle.setPedidosId(pedidoSeleccionado);
        
        pedidoDetalleFacade.create(pedidoDetalle);
        
        listaDetallePedido.add(pedidoDetalle);
        
        pedidoDetalle = new PedidoDetalle(); 
        
        return"agregarProductos.xhtml?faces-redirect=true";   
    }
    
    
    public String preparar(Pedido pedido){
        iniciarConversacion();
        
        this.pedidoSeleccionado = pedido;
        
        return"agregarProductos.xhtml";
        
    }

    public PedidoDetalle getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(PedidoDetalle pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }

    public List<PedidoDetalle> getListaDetallePedido() {
        return listaDetallePedido;
    }

   
    
    
}
