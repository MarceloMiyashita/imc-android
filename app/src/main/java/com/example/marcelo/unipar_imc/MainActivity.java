package com.example.marcelo.unipar_imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double imc;
    String t;

    View.OnClickListener checkBoxListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.bt1);
        final CheckBox m = (CheckBox) findViewById(R.id.masculino);
        final CheckBox f = (CheckBox) findViewById(R.id.feminino);

        bt1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(m.isChecked()){
                    Toast.makeText(MainActivity.this,"MASCULINO",Toast.LENGTH_SHORT).show();
                    TextView sit = (TextView) findViewById(R.id.campo2);
                    final EditText edtpeso = (EditText)findViewById(R.id.edtPeso);
                    final EditText edtAltura = (EditText)findViewById(R.id.edtAltura);
                    double peso = Double.parseDouble(edtpeso.getText().toString());
                    double altura = Double.parseDouble(edtAltura.getText().toString());
                    double imc = peso/(altura*altura);
                    imc = Double.valueOf(String.format(("%.2f"),imc));
                    if(imc < 19.9){
                        Toast.makeText(MainActivity.this,"Abaixo do Normal ",Toast.LENGTH_SHORT).show();
                        sit.setText("Resultado do Imc: "+"Abaixo do Normal");
                    }
                    else{
                        if((imc >=20.0)&&(imc<24.9)){
                            Toast.makeText(MainActivity.this,"Peso Normal ",Toast.LENGTH_SHORT).show();
                            sit.setText("Resultado do Imc: "+"Peso Normal");
                        }
                        else{
                            if((imc >=25.0)&&(imc <29.9)){
                                Toast.makeText(MainActivity.this,"Obesidade Leve  ",Toast.LENGTH_LONG).show();
                                sit.setText("Resultado do Imc: "+"Obesidade Leve");
                            }
                            else
                            if((imc >=30.0)&&(imc <39.9)){
                                Toast.makeText(MainActivity.this,"Obesidade Moderada ",Toast.LENGTH_SHORT).show();
                                sit.setText("Resultado do Imc: "+"Obesidade Moderada");
                            }
                            else {
                                if ((imc >= 40.0)) {
                                    Toast.makeText(MainActivity.this, "Obesidade Mórbida ", Toast.LENGTH_SHORT).show();
                                    sit.setText("Resultado do Imc: "+"Obesidade Mórbida");
                                }
                            }
                        }
                    }
                    String msg2="Valor do Imc : "+imc;
                    final TextView msg = (TextView)findViewById(R.id.campo);
                    msg.setText(msg2);

                }

                else {
                    Toast.makeText(MainActivity.this, "FEMININO", Toast.LENGTH_SHORT).show();
                    TextView sit = (TextView) findViewById(R.id.campo2);
                    final EditText edtpeso = (EditText) findViewById(R.id.edtPeso);
                    final EditText edtAltura = (EditText) findViewById(R.id.edtAltura);
                    double peso = Double.parseDouble(edtpeso.getText().toString());
                    double altura = Double.parseDouble(edtAltura.getText().toString());
                    double imc = peso / (altura * altura);
                    imc = Double.valueOf(String.format(("%.2f"),imc));
                    if (imc < 19.1) {
                        Toast.makeText(MainActivity.this, "Abaixo do Normal", Toast.LENGTH_SHORT).show();
                        sit.setText("Resultado do Imc: "+"Abaixo do Normal");
                    } else {
                        if ((imc >= 19.1) && (imc < 23.9)) {
                            Toast.makeText(MainActivity.this, "Peso Normal ", Toast.LENGTH_SHORT).show();
                            sit.setText("Resultado do Imc: "+"Peso Normal");
                        } else {
                            if ((imc >= 24.0) && (imc < 28.9)) {
                                Toast.makeText(MainActivity.this, "Obesidade Leve ", Toast.LENGTH_LONG).show();
                                sit.setText("Resultado do Imc: "+"Obesidade Leve");
                            } else {
                                if ((imc >= 29.0) && (imc < 38.9)) {
                                    Toast.makeText(MainActivity.this, "Obesidade Moderada", Toast.LENGTH_LONG).show();
                                    sit.setText("Resultado do Imc: "+"Obesidade Moderada");
                                } else {
                                    if ((imc > 39)) {
                                        Toast.makeText(MainActivity.this, "Obesidade Mórbida", Toast.LENGTH_SHORT).show();
                                        sit.setText("Resultado do Imc: "+"Obesidade Mórbida");
                                    }
                                }
                            }
                        }
                    }
                    String msg2="Valor do Imc: "+imc;
                    final TextView msg = (TextView)findViewById(R.id.campo);
                    msg.setText(msg2);

                }

            }

        });




        final Button reset = (Button)findViewById(R.id.btlimpar);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v==reset) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });
    }

}