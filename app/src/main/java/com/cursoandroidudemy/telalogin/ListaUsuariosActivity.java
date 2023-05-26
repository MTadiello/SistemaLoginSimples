package com.cursoandroidudemy.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaUsuariosActivity extends AppCompatActivity implements AdapterUserList.OnClick {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Criando repository
        RepositoryUsers repositoryUsers = new RepositoryUsers(this);

        //Chamando a listview e buscando os usuarios cadastrados
        ListView listUsuarios = findViewById(R.id.listUsuarios);

        //Criando o Adapter para usar o layout simple_list(padrão do android) usando a lista de usuarios
        AdapterUserList adapterUserList = new AdapterUserList(this, repositoryUsers.listarUsuario(),this);


        listUsuarios.setAdapter(adapterUserList);


    }



    @Override
    public void onClick(Usuario usuario) {

        RepositoryUsers repositoryUsers = new RepositoryUsers(this);
        repositoryUsers.deletarUsuario(usuario);
        Toast.makeText(this,"Usuario deletado com sucesso!",Toast.LENGTH_LONG).show();

        ListView listUsuarios = findViewById(R.id.listUsuarios);
        AdapterUserList adapterUserList = new AdapterUserList(this, repositoryUsers.listarUsuario(),this);
        listUsuarios.setAdapter(adapterUserList);

    }
}