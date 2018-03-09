package br.iff.pooa20172.p1_2017_2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;


import java.io.Serializable;
import java.util.ArrayList;

public class ProdutoActivity extends AppCompatActivity implements Serializable {
    private ArrayAdapter adapter;
    private ArrayList<Produto> produto;
    private Produto pr;
    int pos, inicio = 0;
    double total_pedido = 0.0;
    private static final int REQUEST_CODE_CONFIRMACAO = 0;
    Pedido objPedido;
    public Cliente[] objCliente;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        ListView lista = (ListView) findViewById(R.id.lvEquipes);
        final ArrayList<Produto> produto = adicionarProduto();
        final Intent intent = getIntent();
        objCliente = (Cliente[]) intent.getSerializableExtra("clientes");
        id = (int) intent.getSerializableExtra("id");
        objPedido = new Pedido();
        adapter = new ProdutoAdapter(this, produto);
        lista.setAdapter(adapter);
        Button button_finalizar = (Button) findViewById(R.id.button_finalizar);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos = i;
                Intent intent = new Intent(ProdutoActivity.this, AdicionarProdutoActivity.class);
                Bundle bundle = produto.get(i).toBundle();
                intent.putExtras(bundle);
                intent.putExtra("pos", pos);
                startActivityForResult(intent, REQUEST_CODE_CONFIRMACAO);
            }
        });
        button_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objPedido.setTotal_pedido(total_pedido);
                if (total_pedido==0.0){
                    String msg = "Você ainda não escolheu nenhum produto";
                    AlertDialog.Builder dlg = new AlertDialog.Builder(ProdutoActivity.this);
                    dlg.setMessage(msg);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
                else{
                    final RadioButton rb_dinheiro = (RadioButton)findViewById(R.id.rb_dinheiro);
                    final RadioButton rb_credito = (RadioButton)findViewById(R.id.rb_credito);
                    final RadioButton rb_debito = (RadioButton)findViewById(R.id.rb_debito);
                    String pagamento;
                    if((rb_dinheiro.isChecked()==false)&&(rb_credito.isChecked()==false)&&(rb_debito.isChecked()==false)){
                        String msg = "Selecione uma forma de pagamento";
                        AlertDialog.Builder dlg = new AlertDialog.Builder(ProdutoActivity.this);
                        dlg.setMessage(msg);
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                    else{
                        if(rb_dinheiro.isChecked()==true){
                            pagamento = "Dinheiro";
                            objPedido.setFormaPagamento(pagamento);
                        }
                        if(rb_credito.isChecked()==true){
                            pagamento = "Crédito";
                            objPedido.setFormaPagamento(pagamento);
                        }
                        if(rb_debito.isChecked()==true){
                            pagamento = "Débito";
                            objPedido.setFormaPagamento(pagamento);
                        }
                        Intent intent = new Intent(ProdutoActivity.this, IdentificacaoActivity.class);
                        intent.putExtra("pedido", objPedido);
                        intent.putExtra("clientes", objCliente);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent retorno) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_CONFIRMACAO) {
            Bundle dados = retorno.getExtras();
            pr = produto.get(pos);
            if(dados.containsKey("quantidade")){
                pr.setQuantidade(dados.getInt("quantidade"));
                objPedido.setObjProduto(pr);
                objPedido.adicionarItem();
            }
            if(dados.containsKey("valorPedido")){
                TextView tv_total = (TextView) findViewById(R.id.tv_total);
                total_pedido = total_pedido + dados.getDouble("valorPedido");
                String s_valorPedido = String.valueOf(total_pedido);
                tv_total.setText("Total do Pedido: "+s_valorPedido);
            }
            adapter.notifyDataSetChanged();
        }
    }

    private ArrayList<Produto> adicionarProduto() {
        produto = new ArrayList<Produto>();
        Produto produto1 = new Produto("Carne de sol com nata", "Tiras de carne de sol com molho de nata", 12.00, R.drawable.produto1, 0);
        produto.add(produto1);
        Produto produto2 = new Produto("Arroz de Queijo", "Arroz feito com queijo de coalho", 8.00, R.drawable.produto2, 0);
        produto.add(produto2);
        Produto produto3 = new Produto("Suvaco de Cobra", "Carne de sol moída, milho e cebola.", 15.00, R.drawable.produto3, 0);
        produto.add(produto3);
        Produto produto4 = new Produto("Gororoba de Charque", "Purê com queijo e carne de charque.", 18.00, R.drawable.produto4, 0);
        produto.add(produto4);
        Produto produto5 = new Produto("Buchada", "Feito com as vísceras de bode", 15.00, R.drawable.produto5, 0);
        produto.add(produto5);
        Produto produto6 = new Produto("Cartola Oba-Oba", "Banana frita com queijo derretido", 5.00, R.drawable.sobremesa1, 0);
        produto.add(produto6);
        Produto produto7 = new Produto("Cocada", "Cocada mole servida no prato", 4.00, R.drawable.sobremesa2, 0);
        produto.add(produto7);
        Produto produto8 = new Produto("Côco Zoinho", "Uma quenga de côco com bananas caramelizadas", 10.00, R.drawable.sobremesa3, 0);
        produto.add(produto8);
        Produto produto9 = new Produto("Torta de Maça", "Uma das tortas mais tradicionais do mundo", 19.00, R.drawable.sobremesa4, 0);
        produto.add(produto9);
        Produto produto10 = new Produto("Doce de Caju", "Tradicional doce caseiro de caju", 5.00, R.drawable.sobremesa5, 0);
        produto.add(produto10);
        Produto produto11 = new Produto("Caldo de Cana", "Líquido extraído na moagem da cana", 3.00, R.drawable.bebida1, 0);
        produto.add(produto11);
        Produto produto12 = new Produto("Maltado Gelado", "Leite com chocalate em pó", 5.00, R.drawable.bebida2, 0);
        produto.add(produto12);
        Produto produto13 = new Produto("Caipiroska", "Caipiroskas de frutas", 5.00, R.drawable.bebida3, 0);
        produto.add(produto13);
        return produto;
    }
}
