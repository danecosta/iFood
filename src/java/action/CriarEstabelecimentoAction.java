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
public class CriarEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            request.getRequestDispatcher("cadastrarEstabelecimento.jsp").include(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(CriarEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
