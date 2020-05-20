package com.example.telainicial.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.telainicial.CriarAnotacao;
import com.example.telainicial.MainActivity;
import com.example.telainicial.R;

public class EditarAnotacoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_anotacoes);

        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        final Cursor cursor = bancoDeDados.consultarAnotacaoPeloId(this.getIntent().getIntExtra("id", 0));

        EditText titulo = (EditText)findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText)findViewById(R.id.campoConteudo);

        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        conteudo.setText(cursor.getString(cursor.getColumnIndexOrThrow("conteudo")));



    }

    public void atualizarAnotacao(View view) {
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText)findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText)findViewById(R.id.campoConteudo);

        try{
            bancoDeDados.atualizarAnotacao(this.getIntent().getIntExtra("id", 0),
                    titulo.getText().toString(), conteudo.getText().toString());
            Toast.makeText(getApplicationContext(), "Anotação atualizada com sucesso!", Toast.LENGTH_LONG).show();

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Não foi possível atualizar a anotação", Toast.LENGTH_LONG).show();
        }
        voltar(view);
    }

    public void excluirAnotacao(View v){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        EditText titulo = (EditText)findViewById(R.id.campoTitulo);
        EditText conteudo = (EditText)findViewById((R.id.campoConteudo));

        try{
            bancoDeDados.excluirAnotacao(this.getIntent().getIntExtra("id", 0),
                    titulo.getText().toString(), conteudo.getText().toString() );
            Toast.makeText(getApplicationContext(), "Exclusão feita com sucesso!", Toast.LENGTH_LONG).show();

        } catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Não foi possível excluir anotação", Toast.LENGTH_LONG).show();
        }
        voltar(v);

    }

    public void voltar(View v){
        Intent startNewActivty = new Intent(this, MainActivity.class);
        startActivity(startNewActivty);
    }
}
