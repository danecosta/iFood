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
import model.Cliente;
import model.Estabelecimento;
import persistence.ClienteDAO;
import persistence.EstabelecimentoDAO;

/**
 *
 * @author dccosta2
 */
public class CriarPedidoAction implements Action {

    public CriarPedidoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            List<Cliente> clientes = ClienteDAO.getInstance().getAll();
            request.setAttribute("clientes", clientes);

            List<Estabelecimento> estabelecimentos = EstabelecimentoDAO.getInstance().getAll();
            request.setAttribute("estabelecimentos", estabelecimentos);

            request.getRequestDispatcher("cadastrarPedido.jsp").include(request, response);

        } catch (SQLException | ClassNotFoundException | ServletException ex) {
            Logger.getLogger(CriarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
