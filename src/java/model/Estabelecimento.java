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
public class Estabelecimento {

    private int codEstabelecimento;
    private String nome;

    public Estabelecimento(int codEstabelecimento, String nome) {
        this.codEstabelecimento = codEstabelecimento;
        this.nome = nome;
    }

    public Estabelecimento() {
    }

    public int getCodEstabelecimento() {
        return codEstabelecimento;
    }

    public void setCodEstabelecimento(int codEstabelecimento) {
        this.codEstabelecimento = codEstabelecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
