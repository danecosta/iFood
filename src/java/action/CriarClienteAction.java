/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dccosta2
 */
public class CriarClienteAction implements Action {

    public CriarClienteAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            request.getRequestDispatcher("cadastrarCliente.jsp").include(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(CriarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
