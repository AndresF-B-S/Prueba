package com.controladores.pedidos;

import com.modelo.dao.PedidoFacade;
import com.modelo.entidades.Pedido;
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
@Named(value = "controladorListarPedidos")
@ViewScoped
public class ControladorListarPedidos implements Serializable{

    @EJB
    private PedidoFacade pedidoFacade;
    
    private List<Pedido> listaPedidos;
    
    public ControladorListarPedidos() {
    }
    
    @PostConstruct
    
    public void init(){
        
        listaPedidos = pedidoFacade.findAll();
    
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }
    
    
}
