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
public class PedidoEstadoEmPreparo implements PedidoEstado {

    @Override
    public String getDescricao() {
        return "Em preparo";
    }

    @Override
    public void realizarPedido(Pedido pedido) {
    }

    @Override
    public void prepararPedido(Pedido pedido) {
    }

    @Override
    public void enviarPedido(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEnviado());
    }

    @Override
    public void entregarPedido(Pedido pedido) {
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
    }

}
