package com.zwartapps.conversor2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        setTitle(R.string.title2); //Ponemos el titulo en la pantalla

        //Atributos
        Button buttonConvert = findViewById(R.id.buttonConvert);
        Button buttonReset = findViewById(R.id.buttonReset);
        Button buttonEuroDollar = findViewById(R.id.buttoneurodollar);
        final EditText textoDolares = findViewById(R.id.editTextDolares);
        final TextView textoEuro = findViewById(R.id.textEuros);

        //Recuperamos el valor del dollar que teniamos en la primera activity
        Bundle bundle = getIntent().getExtras();
        String tmp = bundle.getString("valor");
        textoDolares.setText(String.valueOf(tmp));


        //Queremos que solamente se muestran 2 decimales en el resultado
        final DecimalFormat df2 = new DecimalFormat(".##");

        //Accion de calculo cuando se pulsa el boton de Convertir
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un String temporal por si el usuario no introduce nada, aparece un mensaje
                String tmp = textoDolares.getText().toString();

                if (tmp.equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Introduzca una Cantidad", Toast.LENGTH_SHORT).show();
                } else {

                    double d = Double.parseDouble(String.valueOf(textoDolares.getText()));
                    double resultado = d / 1.22600;
                    textoEuro.setText(String.valueOf(df2.format(resultado)));
                }
            }
        });

        //Creamos el codigo para borar ambos campos cuando se pulsa el boton borrar
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoEuro.setText("");
                textoDolares.setText("");
            }
        });

        /*Creamos el codigo para cerrar el Activity actual, no invocamos el main activity porque sería cargar
        de nuevo el mainActivity y despues otra vez el secundario y así se iría llenando la memoria innecesariamente*/
        buttonEuroDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
    }
}