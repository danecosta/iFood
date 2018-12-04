/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dane
 */
public class Pagamento {

    int codPagamento;
    String valor;
    String tipoPagamento;

    public Pagamento(int codPagamento, String descricao, String valor) {
        this.codPagamento = codPagamento;
        this.valor = valor;
    }

    public int getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(int codTipoPagamento) {
        this.codPagamento = codTipoPagamento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
