package br.iff.pooa20172.p1_2017_2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Higor on 15/12/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto>{
    private final Context context;
    private final ArrayList<Produto> elementos;

    public ProdutoAdapter(Context context, ArrayList<Produto> elementos) {
        super(context, R.layout.item_produto, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_produto, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.nome);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);
        TextView descricao = (TextView) rowView.findViewById(R.id.descricao);
        TextView preco = (TextView) rowView.findViewById(R.id.preco);
        String s_Preco = String.valueOf(elementos.get(position).getPreco());
        TextView quantidade = (TextView) rowView.findViewById(R.id.quantidade);
        String s_quantidade = String.valueOf(elementos.get(position).getQuantidade());
        nome.setText(elementos.get(position).getNome());
        imagem.setImageResource(elementos.get(position).getImagem());
        descricao.setText(elementos.get(position).getDescricao());
        preco.setText("Preço: R$"+s_Preco);
        quantidade.setText("Quantidade: "+s_quantidade);
        return rowView;
    }

}
