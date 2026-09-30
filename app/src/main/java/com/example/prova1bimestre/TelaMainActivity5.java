package com.example.prova1bimestre;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TelaMainActivity5 extends AppCompatActivity {

    private TextView txtNomeFinal, txtPontuacao, txtDesempenho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main5);

        txtNomeFinal = findViewById(R.id.txtNomeFinal);
        txtPontuacao = findViewById(R.id.txtPontuacao);
        txtDesempenho = findViewById(R.id.txtDesempenho);

        // Recupera os dados enviados pela tela anterior
        String nome = getIntent().getStringExtra("NOME_USUARIO");
        int pontuacaoFinal = getIntent().getIntExtra("PONTUACAO_ATUAL", 0);

        txtNomeFinal.setText("Participante: " + nome);
        txtPontuacao.setText("Pontuação: " + pontuacaoFinal);

        // Mensagens oficiais exigidas na prova de acordo com a pontuação[cite: 1]
        String mensagem = "";
        if (pontuacaoFinal == 12) {
            mensagem = "Você é um verdadeiro mestre da Vexilologia";
        } else if (pontuacaoFinal == 8) {
            mensagem = "Você conhece sobre bandeiras, mas ainda pode melhorar";
        } else if (pontuacaoFinal == 4) {
            mensagem = "Você não é versado nas artes da Vexilologia";
        } else {
            mensagem = "Você para o ensino fundamental";
        }

        txtDesempenho.setText(mensagem);
    }
}