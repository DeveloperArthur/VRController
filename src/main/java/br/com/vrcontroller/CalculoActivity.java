package br.com.vrcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class CalculoActivity extends AppCompatActivity {
    public TextView resultado;
    double valorDia, valorVR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);
        this.resultado = findViewById(R.id.resultado);
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        if (bundle != null) {
            valorDia = bundle.getDouble("valorDia");
            valorVR = bundle.getDouble("valorVR");
            this.calcularDiasParaUsarVR(valorDia, valorVR);
        }
    }

    public void calcularDiasParaUsarVR(double valorDia, double valorVR) {
        if (valorVR < valorDia) {
            this.resultado.setText("Saldo insuficiente para almoçar");
        } else {
            Calendar calendario = Calendar.getInstance();

            int diaAtual = calendario.get(Calendar.DAY_OF_MONTH);
            int ultimoDia = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);

            double aux = valorVR;
            int diaQueOVRAcaba = 0;
            for (int i = diaAtual; i <= ultimoDia; i++) {
                if (calendario.get(Calendar.DAY_OF_WEEK) != 7 && calendario.get(Calendar.DAY_OF_WEEK) != 1) {
                    aux = aux - valorDia;
                    if (aux >= 0) {
                        System.out.println("LOG: DIA " + i + " VALOR ATUAL == " + aux);
                        diaQueOVRAcaba = i;
                    } else break;
                }
                calendario.add(Calendar.DAY_OF_MONTH, 1);
            }
            this.resultado.setText("Voce poderá almocar por esse valor até dia " + diaQueOVRAcaba + " desse mês!");
        }
    }
}
