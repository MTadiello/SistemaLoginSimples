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

        EditText EditTxtCadastroEmail = findViewById(R.id.EditTxtCadastroEmail);
        EditText EditTxtCadastroSenha = findViewById(R.id.EditTxtCadastroSenha);
        EditText EditTxtCadastroApelido = findViewById(R.id.EditTxtCadastroApelido);

        String Usuario = EditTxtCadastroEmail.getText().toString();
        String Senha = EditTxtCadastroSenha.getText().toString();
        String Apelido = EditTxtCadastroApelido.getText().toString();


        if (Usuario.equals("") || Senha.equals("")) {
            Toast.makeText(this, "Insira valores nos campos", Toast.LENGTH_SHORT).show();
        } else if (verificarEmailExistente(Usuario)) {
            Toast.makeText(this, "E-mail já está cadastrado", Toast.LENGTH_SHORT).show();
        } else {
            users.add(new Usuario(Senha, Usuario, Apelido));

            RepositoryUsers repositoryUsers = new RepositoryUsers(this);
            repositoryUsers.adicionarUsuario(new Usuario(Senha, Usuario, Apelido));


            Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.putExtra("telacadastro", users);
            setResult(RESULT_OK, intent);
            finish();
        }


    }

        public boolean verificarEmailExistente(String email) {

            RepositoryUsers repositoryUsers = new RepositoryUsers(this);

            for (Usuario usuario1 : repositoryUsers.listarUsuario()) {
                if (usuario1.getEmail().equals(email)) {
                    return true;
                }

            }
            return false;
        }


}
