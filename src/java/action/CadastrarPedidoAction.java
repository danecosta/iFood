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
import model.Produto;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;
import state.PedidoEstadoRealizado;

/**
 *
 * @author daniela.costa
 */
public class CadastrarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codPedido = Integer.parseInt(request.getParameter("textCodigo"));
        int codCliente = Integer.parseInt(request.getParameter("textCodigoCliente"));
        int codEstabelecimento = Integer.parseInt(request.getParameter("textCodigoEstabelecimento"));

        try {
            Pedido pedido = new Pedido(codPedido, new PedidoEstadoRealizado(), codCliente, codEstabelecimento, 0);
            PedidoDAO.getInstance().salvar(pedido);

            request.setAttribute("codPedido", codPedido);
            buscarListaProdutos(request, response);

        } catch (SQLException | ClassNotFoundException | ServletException ex) {
            Logger.getLogger(CadastrarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscarListaProdutos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Produto> produtos = ProdutoDAO.getInstance().getAll();
        request.setAttribute("produtos", produtos);

        request.getRequestDispatcher("cadastrarProdutosPedido.jsp").include(request, response);
    }

}
