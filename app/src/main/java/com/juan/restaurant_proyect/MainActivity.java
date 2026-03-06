package com.juan.restaurant_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Creando objetos y constantes
    public static final String USUARIO = "juan15";
    public static final String PASSWORD = "123456";
    public Button btnIngresar;
    public EditText edtUser, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Instanciando los objetos
        btnIngresar = findViewById(R.id.btnIngresar);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);


        //manejando el evento del boton
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //capturando los datos ingresados por usuario para validarlos
                String user = edtUser.getText().toString();
                String password = edtPassword.getText().toString();

                //Validando que no esten vacios
                if(user.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Complete los campo", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Validando que sean iguales
                if(user.equals(USUARIO) && password.equals(PASSWORD)) {

                    //Muestra el mensaje de bienvenida y pasamos a la siguiente activity
                    Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (MainActivity.this, Registro_activity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}