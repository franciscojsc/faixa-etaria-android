package br.com.franciscochaves.faixaetaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnResultadoFaixaEtaria;
    private EditText idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnResultadoFaixaEtaria = findViewById(R.id.button_faixa_etaria);
        idade = findViewById(R.id.edit_faixa_etaria);

        btnResultadoFaixaEtaria.setOnClickListener(this);
        idade.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_faixa_etaria) {
            if (idade.getText().toString().trim().length() > 0) {
                try {
                    int valorDaIdade = Integer.parseInt(String.valueOf(idade.getText()));
                    if (valorDaIdade > 0 && valorDaIdade < 120) {
                        String faixaEtaria = verificarFaixaEtaria(valorDaIdade);
                        idade.setText("");
                        exixbirMessagem("Você é um(a) " + faixaEtaria);
                    } else {
                        idade.setText("");
                        exixbirMessagem("Digite a idade maior que 0 e menor que 120");
                    }
                } catch (Exception ex) {
                    idade.setText("");
                    exixbirMessagem("Digite a idade maior que 0 e menor que 120");
                }
            }
        }
    }

    private String verificarFaixaEtaria(int idade) {
        if ((idade > 0) && (idade <= 12)) {
            return "Criança";
        } else if ((idade > 12) && (idade <= 18)) {
            return "Adolescente";
        }
        return "Adulto";
    }

    private void exixbirMessagem(String messagem) {
        Toast.makeText(getBaseContext(), messagem, Toast.LENGTH_LONG).show();
    }
}