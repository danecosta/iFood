/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Combo;
import persistence.ComboDAO;

/**
 *
 * @author dccosta2
 */
public class CadastrarComboAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codCombo = Integer.parseInt(request.getParameter("textCodigo"));
        String descricao = request.getParameter("textDescricao");
        String produtos = request.getParameter("textCodigoProduto");

        try {
            Combo combo = new Combo(descricao);
            ComboDAO.getInstance().salvar(combo);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarComboAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("listarCombo.jsp");
    }

}
