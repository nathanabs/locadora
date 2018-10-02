/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Nathan
 */
public class Filme {
    private String nome;
    private int estoque;
    private double precoLocacao;

    public Filme() {
    }

    public Filme(String nome, int estoque, double precoLocacao) {
        this.nome = nome;
        this.estoque = estoque;
        this.precoLocacao = precoLocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(double prcoLocacao) {
        this.precoLocacao = prcoLocacao;
    }
    
    
}
