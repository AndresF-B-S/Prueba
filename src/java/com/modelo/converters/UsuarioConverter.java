/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.converters;

import com.modelo.dao.UsuarioFacade;
import com.modelo.entidades.Usuario;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author David
 */
@FacesConverter(value = "usuarioConverter")
public class UsuarioConverter implements Converter{
    
    private UsuarioFacade usuarioFacade;
    
    public UsuarioConverter(){
        usuarioFacade = CDI.current().select(UsuarioFacade.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            try {

                return usuarioFacade.find(Integer.valueOf(value));
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Usuario) {
            return ((Usuario) value).getId().toString();
        }
        return "";

    }
    
}
