package state;

import model.Pedido;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daniela.costa
 */
public class PedidoEstadoCancelado implements PedidoEstado {

    @Override
    public String getDescricao() {
        return "Cancelado";
    }

    @Override
    public void realizarPedido(Pedido pedido) {
    }

    @Override
    public void prepararPedido(Pedido pedido) {
    }

    @Override
    public void enviarPedido(Pedido pedido) {
    }

    @Override
    public void entregarPedido(Pedido pedido) {
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
    }
}
