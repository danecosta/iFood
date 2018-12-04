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
public class PagamentoCartao extends Pagamento {

    private String numeroCartao;

    public PagamentoCartao(int codTipoPagamento, String descricao, String valor) {
        super(codTipoPagamento, descricao, valor);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
