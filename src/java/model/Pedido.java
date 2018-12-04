package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import state.PedidoEstadoRealizado;
import state.PedidoEstado;
import java.util.Observable;

/**
 *
 * @author daniela.costa
 */
public class Pedido extends Observable {

    private int codPedido;

    private PedidoEstado estado;
    private int codCliente;
    private int codEstabelecimento;
    private int codPagamento;

    public Pedido() {
        this.estado = new PedidoEstadoRealizado();
    }

    public Pedido(int codPedido, PedidoEstado estado, int codCliente, int codEstabelecimento, int codTipoPagamento) {
        this.codPedido = codPedido;
        this.estado = estado;
        this.codCliente = codCliente;
        this.codEstabelecimento = codEstabelecimento;
        this.codPagamento = codPagamento;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodEstabelecimento() {
        return codEstabelecimento;
    }

    public void setCodEstabelecimento(int codEstabelecimento) {
        this.codEstabelecimento = codEstabelecimento;
    }

    public int getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(int codPagamento) {
        this.codPagamento = codPagamento;
    }

    public String getEstado() {
        return estado.getDescricao();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }
    
    public void realizarPedido() {
        this.estado.realizarPedido(this);
    }

    public void prepararPedido() {
        this.estado.prepararPedido(this);
    }

    public void enviarPedido() {
        this.estado.enviarPedido(this);
    }

    public void entregarPedido() {
        this.estado.entregarPedido(this);
    }

    public void cancelarPedido() {
        this.estado.cancelarPedido(this);
    }

}
