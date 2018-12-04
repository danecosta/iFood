/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Combo;

/**
 *
 * @author dccosta2
 */
public class ComboDAO {

    private static ComboDAO instance = new ComboDAO();

    public static ComboDAO getInstance() {
        return instance;
    }

    public ComboDAO() {
    }

    public void salvar(Combo combo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Combo> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        List<Combo> combos = new ArrayList<Combo>();

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            result = st.executeQuery("select * from combo");

            while (result.next()) {
                Combo combo = new Combo(result.getString("descricao"));
                combo.setCodCombo(result.getInt("codigo"));
                combos.add(combo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }

        return combos;
    }

    private void closeResources(Statement st, Connection conn) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
    }
}
