package com.example.futb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


public class cancha extends AppCompatActivity {

    ProgressBar barra;
    TextView txtUser;
    TextView txtMarcador;
    ImageView img;
    int contador =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha);
        txtUser = findViewById(R.id.textUserCancha);
        txtMarcador = findViewById(R.id.textContador);
        img = findViewById(R.id.imageView5);
        Bundle datos = this.getIntent().getExtras();
        String User = datos.getString("user");
        txtUser.setText(User);
    }

    public void Apreto(View view) {
        try {
            if (contador == 0){
                contador = contador + 1;
                txtMarcador.setText(contador);
            }else{
                contador = contador + Integer.parseInt(txtMarcador.getText().toString());
                txtMarcador.setText(contador);
            }
            ((ViewGroup)img.getParent()).removeView(img);
            RelativeLayout layout= (RelativeLayout) findViewById(R.id.cacha2_xml);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(190, 190);
            int left = (int) (Math.random() * 1000) + 90;
            int top = (int) (Math.random() * 1900) + 1;
            params.leftMargin = left;
            params.topMargin = top;
            //Carga imagen de recursos
            layout.addView(img,-1, params);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error\n"+e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
