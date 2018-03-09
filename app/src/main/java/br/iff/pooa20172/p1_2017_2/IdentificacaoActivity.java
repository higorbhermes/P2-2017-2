package br.iff.pooa20172.p1_2017_2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;

public class IdentificacaoActivity extends AppCompatActivity implements Serializable{
    public Endereco objEndereco;
    public Pedido objPedido;
    public Cliente[] objCliente;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacao);
        final Intent intent = getIntent();
        objPedido = (Pedido) intent.getSerializableExtra("pedido");
        objCliente = (Cliente[]) intent.getSerializableExtra("clientes");
        id = (int) intent.getSerializableExtra("id");
        Button button_concluir = (Button) findViewById(R.id.button_concluir);
        button_concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rua, bairro, numero, complemento, ponto_referencia;
                EditText et_rua = (EditText) findViewById(R.id.et_Rua);
                EditText et_bairro = (EditText) findViewById(R.id.et_Bairro);
                EditText et_numero = (EditText) findViewById(R.id.et_Numero);
                EditText et_complemento = (EditText) findViewById(R.id.et_Complemento);
                EditText et_referencia = (EditText) findViewById(R.id.et_Referencia);
                rua = et_rua.getText().toString();
                bairro = et_bairro.getText().toString();
                numero = et_numero.getText().toString();
                complemento = et_complemento.getText().toString();
                ponto_referencia = et_referencia.getText().toString();
                if (rua.equals("") || bairro.equals("") || numero.equals("")){
                    String msg = "Ops! Você esqueceu de prencher algum campo importante!";
                    AlertDialog.Builder dlg = new AlertDialog.Builder(IdentificacaoActivity.this);
                    dlg.setMessage(msg);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
                else{
                    objEndereco = new Endereco(rua, bairro, numero, complemento, ponto_referencia);
                    objCliente[id].setObjEndereco(objEndereco);
                    objPedido.setObjCliente(objCliente[id]);
                    Intent intent = new Intent(IdentificacaoActivity.this, MenuActivity.class);
                    intent.putExtra("clientes", objCliente);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });


    }
}
