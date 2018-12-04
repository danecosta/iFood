/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dccosta2
 */
public class PedidoProduto {

    private int codPedido;
    private int codProduto;

    public PedidoProduto(int codPedido, int codProduto) {
        this.codPedido = codPedido;
        this.codProduto = codProduto;
    }

    public PedidoProduto() {
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

}
