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
import model.Produto;

/**
 *
 * @author daniela.costa
 */
public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    public static ProdutoDAO getInstance() {
        return instance;
    }

    public ProdutoDAO() {
    }

    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            st.execute("insert into produto(codigo,descricao,preco)"
                    + " values ('" + produto.getCodProduto()
                    + "', '" + produto.getDescricao()
                    + "', '" + produto.getPreco()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }
    }

    public List<Produto> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        List<Produto> produtos = new ArrayList<Produto>();

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            result = st.executeQuery("select * from produto");

            while (result.next()) {
                Produto produto = new Produto();
                produto.setCodProduto(result.getInt("codigo"));
                produto.setDescricao(result.getString("descricao"));
                produto.setPreco(result.getString("preco"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }

        return produtos;
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
