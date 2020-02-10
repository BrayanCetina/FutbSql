package com.example.futb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    TextView nombre;
    TextView puntos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        nombre = findViewById(R.id.nombre);
        puntos = findViewById(R.id.puntos);

        Bundle datos = this.getIntent().getExtras();
        String User = datos.getString("user");
        nombre.setText(User);

        String Puntos =datos.getString("score");
        puntos.setText(Puntos);
    }
}
