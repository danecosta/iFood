package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author daniela.costa
 */
public class Cliente implements Observer {

    private int codCliente;
    private String nome;

    private String rua;
    private String numero;
    private String bairro;
    private String cep;

    public Cliente(Observable pedido) {
        pedido.addObserver(this);
    }

    public Cliente(int codCliente, String nome, String rua, String numero, String bairro, String cep) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Cliente() {
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public void update(Observable pedidoObservable, Object arg) {
        if (pedidoObservable instanceof Pedido) {
            Pedido pedido = (Pedido) pedidoObservable;
            System.out.println("Olá " + getNome()
                    + ", seu pedido foi atualizado para o status: "
                    + pedido.getEstado());
        }
    }

}
