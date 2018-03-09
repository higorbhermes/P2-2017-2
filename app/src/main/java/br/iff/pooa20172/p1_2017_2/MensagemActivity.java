package br.iff.pooa20172.p1_2017_2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MensagemActivity extends AppCompatActivity {
    public Cliente[] objCliente;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);
        final Intent intent = getIntent();
        objCliente = (Cliente[]) intent.getSerializableExtra("clientes");
        id = (int) intent.getSerializableExtra("id");
        TextView tv_tel = (TextView) findViewById(R.id.tv_tel);
        TextView tv_telEntrega = (TextView) findViewById(R.id.tv_telEntrega);
        TextView tv_emailEmpresa = (TextView) findViewById(R.id.tv_emailEmpresa);
        String tel = "22 997796566";
        String telEntrega = "22 999999999";
        String EmailEmpresa = "restaurantesalex@gmail.com";
        tv_tel.setText(tel);
        tv_telEntrega.setText(telEntrega);
        tv_emailEmpresa.setText(EmailEmpresa);
        Button button_enviar = (Button) findViewById(R.id.button_enviar);
        button_enviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText et_mensagem = (EditText) findViewById(R.id.et_mensagem);
                String mensagem = et_mensagem.getText().toString();
                if(mensagem.equals("")){
                    String msg = "Por favor, digite sua mensagem!";
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MensagemActivity.this);
                    dlg.setMessage(msg);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
                else{
                    Mensagem m = new Mensagem(mensagem, objCliente[id]);
                    Intent intent = new Intent(MensagemActivity.this, MenuActivity.class);
                    intent.putExtra("clientes", objCliente);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            }
        });
    }
}
