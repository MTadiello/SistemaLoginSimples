package com.cursoandroidudemy.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


    }

    ArrayList<Usuario> users = new ArrayList<Usuario>();

    public void onClickCadastrar(View view) {

        EditText editTxtCadastroEmail = findViewById(R.id.EditTxtCadastroEmail);
        EditText editTxtCadastroSenha = findViewById(R.id.EditTxtCadastroSenha);
        EditText editTxtCadastroApelido = findViewById(R.id.EditTxtCadastroApelido);

        String usuario = editTxtCadastroEmail.getText().toString();
        String senha = editTxtCadastroSenha.getText().toString();
        String apelido = editTxtCadastroApelido.getText().toString();


        if (usuario.equals("") || senha.equals("")) {
            Toast.makeText(this, "Insira valores nos campos", Toast.LENGTH_SHORT).show();
        } else if (verificarEmailExistente(usuario)) {
            Toast.makeText(this, "E-mail já está cadastrado", Toast.LENGTH_SHORT).show();
        } else {
            users.add(new Usuario(senha, usuario, apelido));

            RepositoryUsers repositoryUsers = new RepositoryUsers(this);
            repositoryUsers.adicionarUsuario(new Usuario(senha, usuario, apelido));


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
