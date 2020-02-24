package com.example.futb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
    String id,us;
    int contador =0;
    public static int ESPERA=60000;

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
        esperarYCerrar(ESPERA);

    }

    public void esperarYCerrar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                finalizarjuego();
            }
        }, milisegundos);
    }
    public void finalizarjuego() {
        insert();
        Intent cancha = new Intent(this, Final.class);
        cancha.putExtra("user",txtUser.getText().toString());
        cancha.putExtra("score",txtMarcador.getText().toString());
        startActivity(cancha);
        finish();    }

    public void Apreto(View view) {
        try {

            contador = contador + 1;
                txtMarcador.setText(Integer.toString(contador));


            ((ViewGroup)img.getParent()).removeView(img);
            RelativeLayout layout= (RelativeLayout) findViewById(R.id.cacha2_xml);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(190, 190);
            int left = (int) (Math.random() * 950) + 90;
            int top = (int) (Math.random() * 550) + 1;
            params.leftMargin = left;
            params.topMargin = top;
            //Carga imagen de recursos
            layout.addView(img,-1, params);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error\n"+e.toString(),Toast.LENGTH_LONG).show();
        }
    }

    public void insert() {
        sqlhelper baseDatosAdmin = new sqlhelper(this,"Usuarios",null,1);
        SQLiteDatabase bd=baseDatosAdmin.getWritableDatabase();
        //selecionamos los datos del usuario en nuestra sqlite
        Cursor tabla= bd.rawQuery("SELECT * FROM Usuarios",null);
        tabla.moveToFirst();
        do{
            id=tabla.getString(0);
            if(us.toUpperCase().equals(txtUser.getText().toString().toUpperCase())){

            }
        }while(tabla.moveToNext());
        tabla.close();
        bd.close();
            sqlhelper dbh = new sqlhelper(this, "Usuarios", null, 1);

            SQLiteDatabase db = dbh.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("codigo", id+1);
            registro.put("nombre", txtUser.getText().toString());
            registro.put("puntos", txtMarcador.getText().toString());
            db.insert("Usuarios", null, registro);
            db.close();

    }

}
