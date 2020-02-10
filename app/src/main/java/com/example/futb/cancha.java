package com.example.futb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class cancha extends AppCompatActivity {

    ProgressBar barra;
    TextView txtUser;
    TextView txtMarcador;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha);
        barra = findViewById(R.id.progressBar);
        txtUser = findViewById(R.id.texUserCancha);
        txtMarcador = findViewById(R.id.textMarcador);
        img = findViewById(R.id.imageView5);

        Bundle datos = this.getIntent().getExtras();
        String User = datos.getString("user");
        txtUser.setText(User);
    }

    public void Apreto(View view) {
        try {
            ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.my_relative_layout);
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) img.getLayoutParams();
            int left = (int) (Math.random() * 950) + 90;
            int top = (int) (Math.random() * 550) + 1;
            params.leftMargin = left;
            params.topMargin = top;
            layout.addView(img, params);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error\n"+e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
