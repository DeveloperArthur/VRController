package br.com.vrcontroller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public EditText valorVR;
    public EditText valorDia;
    public CheckBox jaAlmocou;
    public TextView erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.valorDia = findViewById(R.id.valorDia);
        this.valorVR = findViewById(R.id.valorVR);
        this.erro = findViewById(R.id.erro);
        this.jaAlmocou = findViewById(R.id.checkBox);
    }

    public void chamarTelaCalculo(View view) {
        System.out.println("ValorVR: " + this.valorVR.getText().toString());
        System.out.println("ValorDia: " + this.valorDia.getText().toString());
        System.out.println("Ja almocou? " + this.jaAlmocou.isChecked());

        if (this.valorVR.getText().toString().equals("") || this.valorDia.getText().toString().equals("")) {
            this.erro.setText("ERRO#1: Todos os campos são obrigatórios");
            this.erro.setTextColor(Color.RED);
        } else if (Double.parseDouble(this.valorVR.getText().toString()) < 0 || Double.parseDouble(this.valorDia.getText().toString()) < 0) {
            this.erro.setText("ERRO#2: Campos preenchidos são inválidos");
            this.erro.setTextColor(Color.RED);
        } else {
            Intent it = new Intent(this, CalculoActivity.class);

            double valorVR = 0;
            double valorDia = 0;
            boolean jaAlmocou = false;

            this.erro.setText("");
            valorVR = Double.parseDouble(this.valorVR.getText().toString());
            valorDia = Double.parseDouble(this.valorDia.getText().toString());
            jaAlmocou = this.jaAlmocou.isChecked();

            it.putExtra("valorVR", valorVR);
            it.putExtra("valorDia", valorDia);
            it.putExtra("jaAlmocou", jaAlmocou);

            startActivity(it);
        }
    }
}
