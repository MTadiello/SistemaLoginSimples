package com.cursoandroidudemy.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaUsuariosActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); Mostra seta de voltar


        //Chamando a listview e buscando os usuarios cadastrados

        ListView listUsuarios = findViewById(R.id.listUsuarios);
        ArrayList<Usuario> users = (ArrayList<Usuario>) getIntent().getSerializableExtra("lista_usuarios");

        //Criando o Adapter para usar o layout simple_list(padrão do android) usando a lista de usuarios
        ArrayAdapter<Usuario> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        listUsuarios.setAdapter(adapter);

    }




}