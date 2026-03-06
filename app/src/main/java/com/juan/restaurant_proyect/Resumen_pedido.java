package com.juan.restaurant_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resumen_pedido extends AppCompatActivity {
    //Creando objetos
    Button btnVerMenu, btnRegresar, btnSalir;
    TextView txvUsuario, txvRubro,txvRestaurante, txvCliente;
//Variable estatica para llevar el nombre del restaurante a otras activitys sin instanciar
    public static String RESTAURANTE_NOMBRE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumen_pedido);

        //Instanciando los objetos
        btnVerMenu = findViewById(R.id.btnVerMenu);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnSalir = findViewById(R.id.btnSalir);
        txvUsuario = findViewById(R.id.txvUsuario);
        txvRestaurante = findViewById(R.id.txvRestaurante);
        txvRubro = findViewById(R.id.txvRubro);
        txvCliente = findViewById(R.id.txvCliente);

        //Capturando los datos de la activity anterior
        Bundle bundle = getIntent().getExtras();
        String nombreRestaurante = bundle.getString("nombreRestaurante");
        String rubro = bundle.getString("rubro");
        String nombreCliente = bundle.getString("nombreCliente");
        RESTAURANTE_NOMBRE = nombreRestaurante;


        //Insertando los datos obtenidos a los textView
        txvUsuario.setText(MainActivity.USUARIO);
        txvRestaurante.setText(nombreRestaurante);
        txvRubro.setText(rubro);
        txvCliente.setText(nombreCliente);

        //Manejando los eventos de los botones
        btnVerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resumen_pedido.this, Menu.class);
                startActivity(intent);

            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resumen_pedido.this, Registro_activity.class);
                startActivity(intent);

            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });



    }
}