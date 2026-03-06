package com.juan.restaurant_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Registro_activity extends AppCompatActivity {
    //Declarando objetos
    Button btnContinuar;
    EditText edtNombreRestaurante, edtRubro, edtNombreCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        //Instanciando objetos
        btnContinuar = findViewById(R.id.btnContinuar);
        edtNombreRestaurante = findViewById(R.id.edtNombreRestaurante);
        edtRubro = findViewById(R.id.edtRubro);
        edtNombreCliente = findViewById(R.id.edtNombreCliente);


    //Manejando el evento del boton
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creando un intento para llegar a la siguiente activity
                Intent intent = new Intent(Registro_activity.this, Resumen_pedido.class);

                //Capturando los datos
                String nombreRestaurante = edtNombreRestaurante.getText().toString();
                String rubro = edtRubro.getText().toString();
                String nombreCliente = edtNombreCliente.getText().toString();

                //Validando que no esten vacios
                if(nombreRestaurante.isEmpty() || rubro.isEmpty() || nombreCliente.isEmpty()){
                    Toast.makeText(Registro_activity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                //llevando los datos a la otra activity
                intent.putExtra("nombreRestaurante", nombreRestaurante);
                intent.putExtra("rubro", rubro);
                intent.putExtra("nombreCliente", nombreCliente);

                //Iniciando la activity
                startActivity(intent);
            }
        });
    }
}