package com.cursoandroidudemy.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Usuario> usuarioCadastro = new ArrayList<Usuario>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        RepositoryUsers repositoryUsers = new RepositoryUsers(this);
        usuarioCadastro = repositoryUsers.listarUsuario();
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void onClickLogin(View view) {
        //Buscando os edittxt no layout
        EditText tLogin = findViewById(R.id.tLogin);
        EditText tSenha = findViewById(R.id.tSenha);
        //Pegando os valores inseridos pelo o usuario
        String login = tLogin.getText().toString();
        String senha = tSenha.getText().toString();

        boolean existeUsuario = false;

        Usuario usuario = null;


        for (Usuario c : usuarioCadastro) {

            if (login.equals(c.getEmail()) && senha.equals(c.getSenha())) {
                existeUsuario = true;
                usuario = c;
                break;
            } else {
                existeUsuario = false;
            }


        }
        if (existeUsuario == true && usuario != null) {
            alert("Login bem sucessido");

            Bundle bundle = new Bundle();
            bundle.putString("Meu_nome", usuario.getApelido() );

            Intent intent = new Intent(this, WelcomeActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent, 1);

            tLogin.setText("");
            tSenha.setText("");


        } else {
            alert("Usuário ou senha incorretos");
        }

    }

    public void onClickCadastro(View view) {

        Intent intent = new Intent(this, CadastroActivity.class);
        startActivityForResult(intent, 2);
    }

     public void onClickListaUsuarios(View view) {

        Intent intent = new Intent(this, ListaUsuariosActivity.class);
        startActivity(intent);

    }
}