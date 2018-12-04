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
import model.Produto;
import persistence.ProdutoDAO;

/**
 *
 * @author daniela.costa
 */
public class CadastrarProdutoAction implements Action {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codProduto = Integer.parseInt(request.getParameter("textCodigo"));
        String descricao = request.getParameter("textDescricao");
        String preco = request.getParameter("textPreco");
        int codEstabelecimento = Integer.parseInt(request.getParameter("textCodigoEstabelecimento"));
        
        if (descricao.equals("") || preco.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                
                Produto produto = new Produto();
                produto.setCodProduto(codProduto).setDescricao(descricao).setPreco(preco).setCodEstabelecimento(codEstabelecimento);
                ProdutoDAO.getInstance().save(produto);
                
                buscarListaProdutos(request, response);
                
            } catch (SQLException | ClassNotFoundException | ServletException ex) {
                Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void buscarListaProdutos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Produto> produtos = ProdutoDAO.getInstance().getAll();
        
        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("listarProduto.jsp").include(request, response);
    }
    
}
