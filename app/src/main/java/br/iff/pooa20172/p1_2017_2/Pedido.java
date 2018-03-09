package br.iff.pooa20172.p1_2017_2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Higor on 16/12/2017.
 */

public class Pedido implements Serializable{
    int id, cont=0;
    public Produto[] produto;
    Produto objProduto;
    Endereco objEndereco;
    Cliente objCliente;
    double total_pedido;
    String FormaPagamento;
    public void adicionarItem(){
        if (cont==0){
            produto = new Produto[15];
            produto[cont] = new Produto(objProduto.getNome(), objProduto.getDescricao(), objProduto.getPreco(),objProduto.getImagem(), objProduto.getQuantidade());
            objProduto = null;
            cont++;
        }
        else{
            produto[cont] = new Produto(objProduto.getNome(), objProduto.getDescricao(), objProduto.getPreco(),objProduto.getImagem(), objProduto.getQuantidade());
            objProduto = null;
            cont++;
        }
    }

    public double getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
    }

    public void setFormaPagamento(String formaPagamento) {
        FormaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public Produto[] getProduto() {
        return produto;
    }

    public void setProduto(Produto[] produto) {
        this.produto = produto;
    }

    public Produto getObjProduto() {
        return objProduto;
    }

    public void setObjProduto(Produto objProduto) {
        this.objProduto = objProduto;
    }

    public Endereco getObjEndereco() {
        return objEndereco;
    }

    public void setObjEndereco(Endereco objEndereco) {
        this.objEndereco = objEndereco;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }
}
