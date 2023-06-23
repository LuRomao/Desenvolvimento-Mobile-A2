package com.example.trabalhoa2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trabalhoa2.R;

public class InserirDadosClienteActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextTelefone;
    private Button botaoCadastrarCliente;
    private Button botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados_cliente);

        editTextNome = findViewById(R.id.editTextNomeDoClienteReserva);
        editTextTelefone = findViewById(R.id.editTextCelularDoCliente);
        botaoCadastrarCliente = findViewById(R.id.botaoReservar);
        botaoCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK, new Intent()
                        .putExtra("nomeCliente", editTextNome.getText().toString())
                        .putExtra("telefoneCliente", editTextTelefone.getText().toString()));
                finish();
            }
        });

        botaoVoltar = findViewById(R.id.botaoVoltarInserirDadosCliente);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}