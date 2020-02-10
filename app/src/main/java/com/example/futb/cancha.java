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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancha);
        //txtUser = findViewById(R.id.texUserCancha);
        img = findViewById(R.id.imageView5);
        //Bundle datos = this.getIntent().getExtras();
        //String User = datos.getString("user");
        //txtUser.setText(User);
    }

    public void Apreto(View view) {
        try {
            ((ViewGroup)img.getParent()).removeView(img);
            RelativeLayout layout= (RelativeLayout) findViewById(R.id.cacha2_xml);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200, 200);
            int left = (int) (Math.random() * 900) + 90;
            int top = (int) (Math.random() * 1080) + 1;
            params.leftMargin = left;
            params.topMargin = top;
            //Carga imagen de recursos
            layout.addView(img,-1, params);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error\n"+e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
