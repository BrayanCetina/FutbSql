package com.example.futb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

        TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.txtCorreo);
    }

    public void cancha (View view){
        //validar que el campo no este vacio
        if (TextUtils.isEmpty(txtUser.getText().toString())){
            Toast.makeText(MainActivity.this,"Favor de ingresar un Nombre de Usuario",Toast.LENGTH_SHORT).show();
        //ahora se valida que el nombre del usuario sea mayor o igual a 3 caracteres
        }else if(txtUser.length()<=3){
            Toast.makeText(MainActivity.this,"Favor de ingresar minimo 3 caracteres",Toast.LENGTH_SHORT).show();
        }else {
            Intent cancha = new Intent(this, cancha.class);
            cancha.putExtra("user", txtUser.getText().toString());
            startActivity(cancha);
            finish();
        }
    }
}
