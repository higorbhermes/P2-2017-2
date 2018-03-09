package br.iff.pooa20172.p1_2017_2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable{

    public final Cliente[] objCliente = new Cliente[5];
    private static final int REQUEST_CODE_CONFIRMACAO = 0;
    int cont = 1;
    int i = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_entrar = (Button) findViewById(R.id.button_entrar);
        Button button_cadastro = (Button) findViewById(R.id.button_cadastro);
        objCliente[0] = new Cliente("Higor", "163057", "997796566", "admin", "admin");
        objCliente[1] = new Cliente();
        objCliente[2] = new Cliente();
        objCliente[3] = new Cliente();
        objCliente[4] = new Cliente();
        button_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et_email = (EditText) findViewById(R.id.et_email);
                EditText et_senha = (EditText) findViewById(R.id.et_senha);
                String email = et_email.getText().toString();
                String senha = et_senha.getText().toString();
                if ((email.equals(objCliente[0].getEmail()))&&(senha.equals(objCliente[0].getSenha()))){
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    intent.putExtra("clientes", objCliente);
                    intent.putExtra("id", 0);
                    startActivity(intent);
                }
                else {
                    if ((email.equals(objCliente[1].getEmail())) && (senha.equals(objCliente[1].getSenha()))) {
                        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                        intent.putExtra("clientes", objCliente);
                        intent.putExtra("id", 1);
                        startActivity(intent);
                    } else {
                        if ((email.equals(objCliente[2].getEmail())) && (senha.equals(objCliente[2].getSenha()))) {
                            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                            intent.putExtra("clientes", objCliente);
                            intent.putExtra("id", 2);
                            startActivity(intent);
                        } else {
                            if ((email.equals(objCliente[3].getEmail())) && (senha.equals(objCliente[3].getSenha()))) {
                                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                                intent.putExtra("clientes", objCliente);
                                intent.putExtra("id", 3);
                                startActivity(intent);
                            } else {
                                if ((email.equals(objCliente[4].getEmail())) && (senha.equals(objCliente[4].getSenha()))) {
                                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                                    intent.putExtra("clientes", objCliente);
                                    intent.putExtra("id", 4);
                                    startActivity(intent);
                                } else {
                                    String msg = "Usuário ou senha inválido";
                                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                                    dlg.setMessage(msg);
                                    dlg.setNeutralButton("OK", null);
                                    dlg.show();
                                }
                            }
                        }
                    }
                }

            }
        });
        button_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CONFIRMACAO);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent retorno) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_CONFIRMACAO) {
            Bundle dados = retorno.getExtras();
            if(dados.containsKey("situacao")){
                if (dados.getInt("situacao")==0){
                    String msg = "Ops! Seu cadastro não pode ser realizado. Tente Novamente!";
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setMessage(msg);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
                if (dados.getInt("situacao")==1){
                    if (dados.getString("email").equals(objCliente[0].getEmail())){
                        String msg = "Este email já está cadastrado!";
                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setMessage(msg);
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                    else {
                        if (dados.getString("email").equals(objCliente[1].getEmail())){
                            String msg = "Este email já está cadastrado!";
                            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                            dlg.setMessage(msg);
                            dlg.setNeutralButton("OK", null);
                            dlg.show();
                        } else {
                            if (dados.getString("email").equals(objCliente[2].getEmail())){
                                String msg = "Este email já está cadastrado!";
                                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                                dlg.setMessage(msg);
                                dlg.setNeutralButton("OK", null);
                                dlg.show();
                            } else {
                                if (dados.getString("email").equals(objCliente[3].getEmail())){
                                    String msg = "Este email já está cadastrado!";
                                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                                    dlg.setMessage(msg);
                                    dlg.setNeutralButton("OK", null);
                                    dlg.show();
                                } else {
                                    if (dados.getString("email").equals(objCliente[4].getEmail())){
                                        String msg = "Este email já está cadastrado!";
                                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                                        dlg.setMessage(msg);
                                        dlg.setNeutralButton("OK", null);
                                        dlg.show();
                                    } else {
                                        String s_email = dados.getString("email");
                                        String s_senha = dados.getString("senha");
                                        objCliente[cont]=new Cliente(dados.getString("nome"), dados.getString("cpf"), dados.getString("telefone"), dados.getString("email"), dados.getString("senha"));
                                        cont++;
                                        String msg = "Seu cadastro foi realizado com sucesso!";
                                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                                        dlg.setMessage(msg);
                                        dlg.setNeutralButton("OK", null);
                                        dlg.show();
                                    }
                                }
                            }
                        }
                    }

                }
            }

        }
    }
}
