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
import model.PedidoProduto;

/**
 *
 * @author dccosta2
 */
public class PedidoProdutoDAO {

    private static PedidoProdutoDAO instance = new PedidoProdutoDAO();

    public static PedidoProdutoDAO getInstance() {
        return instance;
    }

    public PedidoProdutoDAO() {
    }

    public void salvar(PedidoProduto pedidoProduto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedidoproduto(codPedido,codProduto)"
                    + " values ('" + pedidoProduto.getCodPedido()
                    + "', '" + pedidoProduto.getCodProduto()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }
    }

    public List<PedidoProduto> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        List<PedidoProduto> pedidoProdutos = new ArrayList<PedidoProduto>();

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            result = st.executeQuery("select * from pedidoproduto");

            while (result.next()) {
                PedidoProduto pedidoProduto = new PedidoProduto();
                pedidoProduto.setCodPedido(result.getInt("codPedido"));
                pedidoProduto.setCodProduto(result.getInt("codProduto"));
                pedidoProdutos.add(pedidoProduto);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }

        return pedidoProdutos;
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
