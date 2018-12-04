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
import model.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author daniela.costa
 */
public class ListarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Pedido> pedidos = PedidoDAO.getInstance().getAll();

            request.setAttribute("pedidos", pedidos);

            request.getRequestDispatcher("listarPedido.jsp").include(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(ListarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
