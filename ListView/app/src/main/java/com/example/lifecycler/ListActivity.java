package com.example.lifecycler;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.example.lifecycler.Characters.*;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        getIntent().getStringExtra("view");

        //onde os layouts vão ser exibidos
        ListView listView = findViewById(R.id.lvList);

        //List of objects
        Characters yoda = new Characters("Master Yoda", R.drawable.myoda);
        Characters admiral = new Characters("Admiral Ackbar", R.drawable.admiralackbar);
        Characters c3po = new Characters("C-3PO", R.drawable.c3po);
        Characters vader = new Characters("Darth Vader", R.drawable.darthvader);
        Characters grevious = new Characters("General Grevious", R.drawable.gengrevious);
        Characters gov = new Characters("Governor Moff Tarkin", R.drawable.governormofftarkin);
        Characters han = new Characters("Han Solo", R.drawable.hansolo);
        Characters lukesky = new Characters("Luke Skywalker", R.drawable.lukesky);
        Characters obiwan = new Characters("Obi-Wan Kenobi", R.drawable.obiwan);
        Characters padme = new Characters("Padmé Amidala", R.drawable.padmeamidala);
        Characters quigon = new Characters("Qui-Gon Jinn", R.drawable.quigonjinn);

        ArrayList<Characters> charList = new ArrayList<>();
        charList.add(yoda);
        charList.add(admiral);
        charList.add(c3po);
        charList.add(vader);
        charList.add(grevious);
        charList.add(gov);
        charList.add(han);
        charList.add(lukesky);
        charList.add(obiwan);
        charList.add(padme);
        charList.add(quigon);


        // ADAPTER SIMPLES
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, Utilitaria.getListShortName());

        // ADAPTER PERSONALIZADO
        //adapter funciona como gerenciador: pega o item e encaixa no layout
        //correlação de dado com tela
        //existem vários tipos de adapter - no caso foi arrayadapter pois estamos com uma lista simples
        //que "retorna" um array

        //contexto = "onde estou" - referência onde tá sendo construída a lista
        //passando layout de construção da lista
        //nome do campo que vai ser alterado no layout
        //a coleção de itens que é passada
        ArrayAdapter<String> adapter = new ListAdapter(this, R.layout.layout_list, charList);

        //informando para a listview o adaptador
        listView.setAdapter(adapter);


        //ATÉ AGORA TENTATIVA FRUSTRADA DE FAZER UM TOAST

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String id = (String) listView.getItemAtPosition(i);
//
//                String name = charList.get(Integer.parseInt(id)).getName();
//
//                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
//            }
//        });

    }

}
