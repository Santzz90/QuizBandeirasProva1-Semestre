package com.example.prova1bimestre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private RadioGroup radioGroupOpcoes;
    private Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        radioGroupOpcoes = findViewById(R.id.radioGroupOpcoes);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString().trim();

                // Validação de preenchimento obrigatório com equals
                if (nome.equals("")) {
                    Toast.makeText(MainActivity.this, "Digite o nome do participante!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedId = radioGroupOpcoes.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Selecione uma opção!", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton rbSelecionado = findViewById(selectedId);
                int pontuacao = 0;

                // Resposta correta: Brasil (+3 acerto, -1 erro)[cite: 1]
                if (rbSelecionado.getText().toString().equals("Brasil")) {
                    pontuacao += 3;
                } else {
                    pontuacao -= 1;
                }

                Intent intent = new Intent(MainActivity.this, TelaMainActivity2.class);
                intent.putExtra("NOME_USUARIO", nome);
                intent.putExtra("PONTUACAO_ATUAL", pontuacao);
                startActivity(intent);
            }
        });
    }
}