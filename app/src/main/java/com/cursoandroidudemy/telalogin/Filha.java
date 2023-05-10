package com.cursoandroidudemy.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class Filha extends  AppCompatActivity implements Serializable {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filha);

        String login = (String) getIntent().getSerializableExtra("Meu_nome");

        TextView bemVindo = findViewById(R.id.bemVindo);
        bemVindo.setText("Oi "+login);
    }


    public void onClickTelaInicial(View view) {

        Intent intent = new Intent();
        intent.putExtra("telainicial", "welcome");
        setResult(RESULT_OK, intent);
        finish();

    }
}