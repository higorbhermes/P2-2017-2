package br.iff.pooa20172.p1_2017_2;

import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by Higor on 15/12/2017.
 */

public class Produto implements Serializable{
    public Produto(String nome, String descricao, double preco, int imagem, int quantidade){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.quantidade = quantidade;
    }
    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("descricao", descricao);
        bundle.putInt("imagem", imagem);
        bundle.putDouble("preco", preco);
        bundle.putInt("quantidade", quantidade);
        return bundle;
    }
    protected String nome, descricao;
    protected double preco;
    protected int imagem, quantidade;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPreco(double Preco) {
        this.preco = Preco;
    }
    public int getImagem() {
        return imagem;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
