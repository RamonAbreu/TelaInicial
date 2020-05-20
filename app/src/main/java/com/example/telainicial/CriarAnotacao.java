package com.example.telainicial;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.telainicial.bancodedados.BancoDeDados;

public class CriarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anotacao);
    }

    public void criarAnotacao(View view) {
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = findViewById(R.id.campoTitulo);
        EditText conteudo = findViewById(R.id.campoConteudo);

        boolean resultado = bancoDeDados.criarAnotacao(titulo.getText().toString(), conteudo.getText().toString());
        if(resultado) {
            Toast.makeText(getApplicationContext(), "Anotação criada com sucesso", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Infelizmente ocorreu um erro, tente novamente", Toast.LENGTH_LONG );
        }
        voltar(view);
    }


    public void voltar(View view) {
        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);
    }
}
