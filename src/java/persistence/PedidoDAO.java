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
import model.Pedido;

/**
 *
 * @author daniela.costa
 */
public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    public PedidoDAO() {
    }

    public Pedido obterPorId(int codPedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet result = null;
        Pedido pedido = new Pedido();

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();

            result = st.executeQuery("select * from pedido where codigo=" + codPedido);

            while (result.next()) {
                pedido.setCodPedido(result.getInt("codigo"));
                pedido.setCodCliente(result.getInt("codCliente"));
                pedido.setCodEstabelecimento(result.getInt("codEstabelecimento"));
                pedido.setCodPagamento(result.getInt("codPagamento"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }

        return pedido;
    }

    public void salvar(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedido(codigo,estado,codCliente,codEstabelecimento,codPagamento)"
                    + " values ('" + pedido.getCodPedido()
                    + "', '" + pedido.getEstado()
                    + "', '" + pedido.getCodCliente()
                    + "', '" + pedido.getCodEstabelecimento()
                    + "', '" + pedido.getCodPagamento()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }
    }

    public void atualizar(Pedido pedido, String campo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();

            if (campo.equals("estado")) {
                atualizarEstado(pedido, st);
            } else if (campo.equals("pagamento")) {
                atualizarPagamento(pedido, st);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }
    }

    private void atualizarEstado(Pedido pedido, Statement st) throws SQLException, ClassNotFoundException {
        st.execute("update pedido set estado= '" + pedido.getEstado()
                + "' where codigo='" + pedido.getCodPedido() + "'");
    }

    private void atualizarPagamento(Pedido pedido, Statement st) throws SQLException, ClassNotFoundException {
        st.execute("update pedido set codPagamento= '" + pedido.getCodPagamento()
                + "' where codigo='" + pedido.getCodPedido() + "'");
    }

    public List<Pedido> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        List<Pedido> pedidos = new ArrayList<Pedido>();

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            result = st.executeQuery("select * from pedido");

            while (result.next()) {
                Pedido pedido = new Pedido();
                pedido.setCodPedido(result.getInt("codigo"));
                pedido.setCodCliente(result.getInt("codCliente"));
                pedido.setCodEstabelecimento(result.getInt("codEstabelecimento"));
                pedido.setCodPagamento(result.getInt("codPagamento"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }

        return pedidos;
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
