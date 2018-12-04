/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
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
        
        Combo combo = new Combo(descricao);
        ComboDAO.getInstance().salvar(combo);
        response.sendRedirect("listarCombo.jsp");
    }

}
