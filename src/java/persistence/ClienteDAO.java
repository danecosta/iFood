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
import model.Cliente;

/**
 *
 * @author daniela.costa
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    public ClienteDAO() {
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente(codigo,nome,rua,numero,bairro,cep)"
                    + " values ('" + cliente.getCodCliente()
                    + "', '" + cliente.getNome()
                    + "', '" + cliente.getRua()
                    + "', '" + cliente.getNumero()
                    + "', '" + cliente.getBairro()
                    + "', '" + cliente.getCep()
                    + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }
    }

    public List<Cliente> getAll() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            conn = DataBaseLocator.getInsLocator().getConnection();
            st = conn.createStatement();
            result = st.executeQuery("select * from cliente");

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodCliente(result.getInt("codigo"));
                cliente.setNome(result.getString("nome"));
                cliente.setRua(result.getString("rua"));
                cliente.setNumero(result.getString("numero"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCep(result.getString("cep"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(st, conn);
        }

        return clientes;
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
