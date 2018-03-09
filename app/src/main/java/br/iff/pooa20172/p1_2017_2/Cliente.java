package br.iff.pooa20172.p1_2017_2;

import java.io.Serializable;

/**
 * Created by Higor on 16/12/2017.
 */

public class Cliente implements Serializable{
    String nome, cpf, telefone, email, senha;
    Endereco objEndereco;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getObjEndereco() {
        return objEndereco;
    }

    public void setObjEndereco(Endereco objEndereco) {
        this.objEndereco = objEndereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente(String nome, String cpf, String telefone, Endereco objEndereco){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.objEndereco = objEndereco;
    }

    public Cliente(String nome, String cpf, String telefone, String email, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    public Cliente(){

    }
}
