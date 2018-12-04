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
public interface PedidoEstado {

    String getDescricao();

    void realizarPedido(Pedido pedido);

    void prepararPedido(Pedido pedido);

    void enviarPedido(Pedido pedido);

    void entregarPedido(Pedido pedido);

    void cancelarPedido(Pedido pedido);
}
