package br.com.vrcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
            this.calcular(valorDia, valorVR);
        }
    }

    public void calcular(double valorDia, double valorVR) {
        GregorianCalendar calendario = new GregorianCalendar();

        int diaAtual = calendario.get(GregorianCalendar.DAY_OF_MONTH);
        int ultimoDia = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);

        double aux = valorVR;
        int diaQueOVRAcaba = 0;

        for (int i = diaAtual; i <= ultimoDia; i++) {
            aux = aux - valorDia;
            if (aux > 0) {
                System.out.println("LOG: DIA " + i + " VALOR ATUAL == " + aux);
                diaQueOVRAcaba = i;
            } else break;
        }
        this.resultado.setText("Voce podera almocar por esse valor ate dia " + diaQueOVRAcaba);
    }
}
