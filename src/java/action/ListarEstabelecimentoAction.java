/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Estabelecimento;
import persistence.EstabelecimentoDAO;

/**
 *
 * @author daniela.costa
 */
public class ListarEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Estabelecimento> estabelecimentos = EstabelecimentoDAO.getInstance().getAll();

            request.setAttribute("estabelecimentos", estabelecimentos);

            request.getRequestDispatcher("listarEstabelecimento.jsp").include(request, response);

        } catch (ServletException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ListarEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
