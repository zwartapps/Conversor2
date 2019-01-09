# Conversor2
## Tarea UT2 parte 2 de Programación Multimedia y Dispositivos Móviles

### Unidad de Trabajo 02
#### Diseño de la Interfaz de Usuario
#### Práctica a Entregar

Crear un proyecto Android que permita convertir de Euros (€) a Dólares Americanos ($) y viceversa. El cambio
está a:
1 EUR → 1,22600 USD
El proyecto deberá tener dos actividades:
• Actividad principal: Realiza la conversión de Euros a Dólares Americanos.
• Actividad secundaria: Realiza la conversión de Dólares Americanos a Euros
Para ver los detalles, ver el PDF: 
- [PDF Tarea 3](../master/0489_PDMP_PracticaB_UT02_2018_v1.0.pdf)

Creamos el proyecto en Android Studio. El codigo está comentado para entender que hacemos.

Reciclamos gran parte del codigo de la primera parte del Conversor:
Tanto la clase MainActivity.java y el layout mainactivity.xml como los resursos en string.xml
Añadimos un boton para cargar la segunda activity:

<img src="http://i63.tinypic.com/2ywzqde.jpg">

Introducimos una cantidad y pulsamos **Convertir**:

<img src="http://i65.tinypic.com/j6luzs.jpg">

Cuando pulsamos el boton **Conversor Dolares-Euros**, nos lleva a la segunda activity llevando el valor del dolar calculado anteriormente:

<img src="http://i67.tinypic.com/2wg6rs2.jpg">

Esto lo hacemos con el Intent en el main activity:

```
         buttonDollarEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra("valor", textoDollar.getText());
                startActivity(i);
            }
        });
 ```
 Y en la segunda activity, recogemos el valor y lo cargamos:
 
 ```
 //Recuperamos el valor del dollar que teniamos en la primera activity
        Bundle bundle = getIntent().getExtras();
        String tmp = bundle.getString("valor");
        textoDolares.setText(String.valueOf(tmp)); 
```
Cambiamos los nombres y los id de los atributos como proceda. Después para el calculo, 
obviamente tiene que ser la division en vez de multiplicar los valores:

 ```
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
  
 ```
En el segundo Activity no creamos un Intent, sino usamos el metodo finish(). 
Esto para evitar que se vayan cargando las activities sin destruir los anteriores que llenaría la memoria sin necesidad:

 ``` 
  buttonEuroDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
 ``` 
 
 Y pulsando el boton ***Conversor Euros-Dolares***, se cierra la activity actual y se vuelve a la principal:
 
 <img src="http://i68.tinypic.com/24dov9y.jpg">
 
 ### Todo funciona correctamente!
 
 
