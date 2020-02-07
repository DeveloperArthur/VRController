package br.com.vrcontroller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public EditText valorVR;
    public EditText valorDia;
    public TextView erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.valorDia = findViewById(R.id.valorDia);
        this.valorVR = findViewById(R.id.valorVR);
        this.erro = findViewById(R.id.erro);
    }

    public void chamarTelaCalculo(View view) {
        Intent it = new Intent(this, CalculoActivity.class);
        double valorVR = 0;
        double valorDia = 0;

        if (this.valorVR.getText().toString() == null || this.valorDia.getText().toString() == null) {
            this.erro.setText("ERRO: Preencha os campos acima");
            this.erro.setTextColor(Color.RED);
        }else{
            this.erro.setText("");
            try{
                valorVR = Double.parseDouble(this.valorVR.getText().toString());
                valorDia = Double.parseDouble(this.valorDia.getText().toString());

                it.putExtra("valorVR", valorVR);
                it.putExtra("valorDia", valorDia);

                startActivity(it);
            }catch ()

        }
    }
}
