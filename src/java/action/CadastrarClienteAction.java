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
public class CadastrarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codCliente = Integer.parseInt(request.getParameter("textCodigo"));
        String nome = request.getParameter("textNome");
        String rua = request.getParameter("textRua");
        String numero = request.getParameter("textNumero");
        String bairro = request.getParameter("textBairro");
        String cep = request.getParameter("textCep");

        try {
            Cliente cliente = new Cliente(codCliente, nome, rua, numero, bairro, cep);
            ClienteDAO.getInstance().salvar(cliente);

            buscarListaClientes(request, response);

            request.getRequestDispatcher("listarCliente.jsp").include(request, response);

        } catch (SQLException | ClassNotFoundException | ServletException ex) {
            Logger.getLogger(CadastrarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscarListaClientes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Cliente> clientes = ClienteDAO.getInstance().getAll();
        request.setAttribute("clientes", clientes);
    }

}
