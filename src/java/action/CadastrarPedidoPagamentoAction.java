/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
import persistence.PedidoDAO;

/**
 *
 * @author Dane
 */
public class CadastrarPedidoPagamentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codPedido = Integer.parseInt(request.getParameter("codPedido"));
        String tipoPagamento = request.getParameter("textTipoPagamento");

        try {
            Pedido pedido = PedidoDAO.getInstance().obterPorId(codPedido);
            PedidoDAO.getInstance().atualizar(pedido, "CodPagamento");

        } catch (SQLException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CadastrarPedidoPagamentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("listarPedido.jsp");
    }
}
