package br.iff.pooa20172.p1_2017_2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class CadastroActivity extends AppCompatActivity implements Serializable{
    private int situacao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button button_salvarCliente = (Button) findViewById(R.id.button_salvarCliente);
        button_salvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eText_Nome = (EditText) findViewById(R.id.eText_Nome);
                EditText eText_Cpf = (EditText) findViewById(R.id.eText_Cpf);
                EditText eText_Telefone = (EditText) findViewById(R.id.eText_Telefone);
                EditText eText_Email = (EditText) findViewById(R.id.eText_Email);
                EditText eText_Senha = (EditText) findViewById(R.id.eText_Senha);
                EditText eText_Conf_Senha = (EditText) findViewById(R.id.eText_Conf_Senha);
                if (eText_Nome.getText().toString().equals("") || eText_Cpf.getText().toString().equals("") || eText_Telefone.getText().toString().equals("") || eText_Email.getText().toString().equals("") || eText_Senha.getText().toString().equals("") || eText_Conf_Senha.getText().toString().equals("")){
                    String msg = "Todos os campos devem ser preenchidos";
                    AlertDialog.Builder dlg = new AlertDialog.Builder(CadastroActivity.this);
                    dlg.setMessage(msg);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
                else {
                    if ((eText_Conf_Senha.getText().toString().equals(eText_Senha.getText().toString()))==false){
                        String msg = "Atenção! As senhas digitadas são imconpativeis!";
                        AlertDialog.Builder dlg = new AlertDialog.Builder(CadastroActivity.this);
                        dlg.setMessage(msg);
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                    else{
                        finish(eText_Nome.getText().toString(), eText_Cpf.getText().toString(), eText_Email.getText().toString(), eText_Telefone.getText().toString(), eText_Senha.getText().toString());
                    }
                }
            }
        });
    }
    public void finish() {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("situacao", 0);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        super.finish();
    }

    public void finish(String Nome, String Cpf, String Email, String Telefone, String Senha) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("situacao", 1);
        bundle.putString("nome", Nome);
        bundle.putString("cpf", Cpf);
        bundle.putString("email", Email);
        bundle.putString("telefone", Telefone);
        bundle.putString("senha", Senha);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
