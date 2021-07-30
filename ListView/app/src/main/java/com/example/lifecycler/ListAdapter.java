package com.example.lifecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

//classe que oferece recursos
//os métodos utilizados abaixo são a estrutura mínima para se trabalhar com o adapter
public class ListAdapter extends ArrayAdapter<String> {

    //qual activity vai implementar o adapter
    private Context context;
    //
    private int resource;
    private ArrayList<Characters> list;

    //Para caso manipulemos a lista de itens e precise de atualização (adc ou remover)
//    public void setCharacters(ArrayList<Characters> listC){
//        list.addAll(listC);
//    }

    //construtor padrão para dizer o que queremos ter ao instanciar
    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Characters> objects) {
        super(context, resource);
        this.context = context; //classe que montou o adapter - onde será criado a lista de itens / context tem a ver com java
        this.resource = resource; //layout de cada item que vai ser exibido
        this.list = objects; //lista de objetos com os itens
    }

    @NonNull
    @Override
    //cria a referência do layout (o layout em si)
    //constrói a view (layout do item)
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView; //layout em java é do tipo view
        if (itemView == null) {
            //construir a referência do layout
            itemView = LayoutInflater.from(context).inflate(resource, parent, false);
        } // resource = informa como ele vai se parecer // parent = listview retornado já "layoutado" -  tem a ver com tela (context tem a ver com java)
        //o attachtoroot false = impede o item de ficar fixo, é flutuante (pode "scrollar")

        TextView textView = itemView.findViewById(R.id.tvItem); //pego o que quero editar
        textView.setText(list.get(position).getName()); //"seto" o que quero editar

        ImageView imgView = itemView.findViewById(R.id.img);
        imgView.setImageResource(list.get(position).getImgId());

        return itemView;
    }

    @Override
    //retorna o tamanho da listagem de itens (tamanho da coleção) - mapeia a quantidade de itens
    public int getCount() {
        return list.size();
    } // pois está atualizado, no construtor é feito apenas uma vez
}
