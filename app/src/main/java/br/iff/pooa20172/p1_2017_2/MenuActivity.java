package br.iff.pooa20172.p1_2017_2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MenuActivity extends AppCompatActivity implements Serializable{
    public Cliente[] objCliente;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final Intent intent = getIntent();
        objCliente = (Cliente[]) intent.getSerializableExtra("clientes");
        id = (int) intent.getSerializableExtra("id");
        Button button_Pedido = (Button) findViewById(R.id.button_Pedido);
        Button button_QuemSomos = (Button) findViewById(R.id.button_QuemSomos);
        Button button_NossaLocalizacao = (Button) findViewById(R.id.button_Localização);
        Button button_Contatos = (Button) findViewById(R.id.button_Contatos);
        Button button_Sair = (Button) findViewById(R.id.button_Sair);
        button_Pedido.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ProdutoActivity.class);
                intent.putExtra("clientes", objCliente);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        button_QuemSomos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ActivityQuemSomos.class);
                startActivity(intent);
            }
        });
        button_NossaLocalizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, LocalizacaoActivity.class);
                startActivity(intent);
            }
        });
        button_Contatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MensagemActivity.class);
                intent.putExtra("clientes", objCliente);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        button_Sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

