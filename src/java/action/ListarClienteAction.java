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
import persistence.ClienteDAO;

/**
 *
 * @author daniela.costa
 */
public class ListarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Cliente> clientes = ClienteDAO.getInstance().getAll();

            request.setAttribute("clientes", clientes);

            request.getRequestDispatcher("listarCliente.jsp").include(request, response);

        } catch (ServletException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
