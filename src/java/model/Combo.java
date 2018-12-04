/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dccosta2
 */
public class Combo extends Composicao {

    private int codCombo;
    private ArrayList produtos = new ArrayList();

    public Combo(String descricao) {
        super(descricao);
    }

    public int getCodCombo() {
        return codCombo;
    }

    public void setCodCombo(int codCombo) {
        this.codCombo = codCombo;
    }

    @Override
    public String getDescricao() {
        String descricaoSaida = this.descricao + "\n";
        for (Iterator i = produtos.iterator(); i.hasNext();) {
            Produto produto = (Produto) i.next();
            descricaoSaida = descricaoSaida + produto.getDescricao();
        }

        return descricaoSaida;
    }

}
