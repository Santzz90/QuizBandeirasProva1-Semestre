package com.example.prova1bimestre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TelaMainActivity4 extends AppCompatActivity {

    private Button btnAvancar;
    private RadioGroup radioGroupOpcoes; // <-- ADICIONE ESTA LINHA AQUI
    private String nome;
    private int pontuacaoAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main4);

        nome = getIntent().getStringExtra("NOME_USUARIO");
        pontuacaoAtual = getIntent().getIntExtra("PONTUACAO_ATUAL", 0);

        radioGroupOpcoes = findViewById(R.id.radioGroupOpcoes);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupOpcoes.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(TelaMainActivity4.this, "Selecione uma opção!", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton rbSelecionado = findViewById(selectedId);

                // Resposta correta: Arábia Saudita[cite: 1]
                if (rbSelecionado.getText().toString().equals("Arábia Saudita")) {
                    pontuacaoAtual += 3;
                } else {
                    pontuacaoAtual -= 1;
                }

                Intent intent = new Intent(TelaMainActivity4.this, TelaMainActivity5.class);
                intent.putExtra("NOME_USUARIO", nome);
                intent.putExtra("PONTUACAO_ATUAL", pontuacaoAtual);
                startActivity(intent);
            }
        });
    }
}