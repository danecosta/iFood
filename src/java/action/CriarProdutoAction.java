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
 * @author dccosta2
 */
public class CriarProdutoAction implements Action {

    public CriarProdutoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            buscarListaEstabelecimentos(request, response);

            request.getRequestDispatcher("cadastrarProduto.jsp").include(request, response);

        } catch (ClassNotFoundException | ServletException | SQLException ex) {
            Logger.getLogger(CriarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarListaEstabelecimentos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Estabelecimento> estabelecimentos = EstabelecimentoDAO.getInstance().getAll();
        request.setAttribute("estabelecimentos", estabelecimentos);
    }
}
