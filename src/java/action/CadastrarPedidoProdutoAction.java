/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PedidoProduto;
import persistence.PedidoProdutoDAO;

/**
 *
 * @author dccosta2
 */
public class CadastrarPedidoProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codPedido = Integer.parseInt(request.getParameter("codPedido"));
        int codProduto = Integer.parseInt(request.getParameter("textCodigoProduto"));

        try {
            PedidoProduto pedidoProduto = new PedidoProduto(codPedido, codProduto);
            PedidoProdutoDAO.getInstance().salvar(pedidoProduto);

            request.setAttribute("codPedido", codPedido);

            popularListaTiposPagamento(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | ServletException ex) {
            Logger.getLogger(CadastrarPedidoProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popularListaTiposPagamento(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        ArrayList<String> tiposPagamento = new ArrayList<String>();
        tiposPagamento.add("Dinheiro");
        tiposPagamento.add("Cartão de Crédito");
        request.setAttribute("tiposPagamento", tiposPagamento);
        request.getRequestDispatcher("cadastrarTipoPagamentoPedido.jsp").include(request, response);
    }
}
