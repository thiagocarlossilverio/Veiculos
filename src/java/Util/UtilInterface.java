/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Heber
 */
public class UtilInterface {
    public static void msgSucesso(String txt){
        FacesContext.getCurrentInstance().addMessage
                    (null, new FacesMessage("Incluido com Sucesso"));
            
    }
}
