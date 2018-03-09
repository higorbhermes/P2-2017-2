package br.iff.pooa20172.p1_2017_2;

import java.io.Serializable;


/**
 * Created by Higor on 18/12/2017.
 */

public class Mensagem  implements Serializable{
    int id;
    String texto;
    Cliente objCliente;
    Mensagem(String texto, Cliente objCliente){
        this.texto = texto;
        this.objCliente = objCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }
}
