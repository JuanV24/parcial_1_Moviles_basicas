package com.juan.restaurant_proyect;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu extends AppCompatActivity {
    // Arreglo de platillos con temática de Mortal Kombat y Asados
    String[] platillos = {
            "Parrillada Cuatro Brazos",
            "Corte Fatality",
            "Costillas de Dragón de Netherrealm",
            "Puyazo Mortal con Guacamol",
            "T-Bone al Carbón",
            "Chorizos del Infierno",
            "Pechuga 'Liu Kang'",
            "Lomito Sub-Zero",
            "Brochetas de Scorpion",
            "Bebida Soul Steal"
    };

    //Creando objetos
    ListView lvMenu;
    Button btnVolverResumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        //Instanciando los objetos
        lvMenu = findViewById(R.id.lvMenu);
        btnVolverResumen = findViewById(R.id.btnVolverResumen);

        //Creando el adaptador y uniendo los datos
        ArrayAdapter<String> adapter;
        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, platillos)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                 View view = super.getView(position, convertView, parent);
                // Buscamos el TextView interno del layout estándar y le ponemos color blanco
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };

        //uniendo el adaptador con el litView
        lvMenu.setAdapter(adapter);

        //Manejando el click en los items del listView
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Cada vez que hagamos click en un item se mostrara el valor del string y el nombre del restaurnate
                Toast.makeText(Menu.this, "Has seleccionado: " + platillos[position] + "- "+ Resumen_pedido.RESTAURANTE_NOMBRE , Toast.LENGTH_SHORT).show();
            }
        });

        //Manejando el boton de regresar
        btnVolverResumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Resumen_pedido.class);
                startActivity(intent);
            }
        });
    }
}