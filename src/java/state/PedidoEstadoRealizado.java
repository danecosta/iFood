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
public class PedidoEstadoRealizado implements PedidoEstado {

    @Override
    public String getDescricao() {
        return "Realizado";
    }

    @Override
    public void realizarPedido(Pedido pedido) {
    }

    @Override
    public void prepararPedido(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEmPreparo());
    }

    @Override
    public void enviarPedido(Pedido pedido) {
    }

    @Override
    public void entregarPedido(Pedido pedido) {
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
    }

}
