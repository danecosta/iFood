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
import model.Estabelecimento;

/**
 *
 * @author daniela.costa
 */
public class EstabelecimentoDAO {

    private static EstabelecimentoDAO instance = new EstabelecimentoDAO();

    public static EstabelecimentoDAO getInstance() {
        return instance;
    }

    public EstabelecimentoDAO() {
    }

    public void salvar(Estabelecimento estabelecimento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            st.execute("insert into estabelecimento(codigo,nome)"
                    + " values ('" + estabelecimento.getCodEstabelecimento()
                    + "', '" + estabelecimento.getNome()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }
    }

    public List<Estabelecimento> getAll() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            result = st.executeQuery("select * from estabelecimento");

            while (result.next()) {
                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setCodEstabelecimento(result.getInt("codigo"));
                estabelecimento.setNome(result.getString("nome"));
                estabelecimentos.add(estabelecimento);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }

        return estabelecimentos;
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
