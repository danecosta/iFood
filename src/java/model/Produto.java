/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daniela.costa
 */
public class Produto {

    private int CodProduto;

    private String descricao;
    private String preco;
    private int codEstabelecimento;

    public Produto(String descricao, String preco, int codEstabelecimento) {
        this.descricao = descricao;
        this.preco = preco;
        this.codEstabelecimento = codEstabelecimento;
    }

    public Produto() {
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public Produto setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getPreco() {
        return preco;
    }

    public Produto setPreco(String preco) {
        this.preco = preco;
        return this;
    }

    public int getCodEstabelecimento() {
        return codEstabelecimento;
    }

    public Produto setCodEstabelecimento(int codEstabelecimento) {
        this.codEstabelecimento = codEstabelecimento;
        return this;
    }

}
