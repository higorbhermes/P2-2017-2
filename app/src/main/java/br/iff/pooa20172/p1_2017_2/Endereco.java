package br.iff.pooa20172.p1_2017_2;

import java.io.Serializable;

/**
 * Created by Higor on 16/12/2017.
 */

public class Endereco implements Serializable{
    String rua, bairro, numero, complemento, ponto_referencia;
    public Endereco(String rua, String bairro, String numero, String complemento, String ponto_referencia){
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.ponto_referencia = ponto_referencia;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getPonto_referencia() {
        return ponto_referencia;
    }

    public void setPonto_referencia(String ponto_referencia) {
        this.ponto_referencia = ponto_referencia;
    }
}
