package com.cursoandroidudemy.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


    }

    ArrayList<Usuario> users = new ArrayList<Usuario>();

    public void onClickCadastrar(View view) {

        EditText EditTxtCadastroUsuario = findViewById(R.id.EditTxtCadastroUsuario);
        EditText EditTxtCadastroSenha = findViewById(R.id.EditTxtCadastroSenha);

        String Usuario = EditTxtCadastroUsuario.getText().toString();
        String Senha = EditTxtCadastroSenha.getText().toString();




        if (Usuario.equals("") || Senha.equals("")) {
            Toast.makeText(this, "Insira valores nos campos", Toast.LENGTH_SHORT).show();
        } else {
            users.add(new Usuario(Senha, Usuario));
            Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.putExtra("telacadastro", users);
            setResult(RESULT_OK, intent);
            finish();
        }


    }
}