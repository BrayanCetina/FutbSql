package com.example.futb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Final extends AppCompatActivity {
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        selec();
    }
    public void selec() {
        lista = findViewById(R.id.lista);
        //   Toolbar toolbar = findViewById(R.id.toolbarPuntaje);
        //setActionBar(toolbar);
        getSupportActionBar().setTitle("Registros");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayList<String> ranking = new ArrayList<>();

        sqlhelper juego =  new sqlhelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = juego.getWritableDatabase();
        Cursor fila = db.rawQuery("SELECT nombre, puntos FROM Usuarios ORDER BY puntos DESC LIMIT 5",null);
        if(fila.moveToFirst()){
            do{
                ranking.add("      "+fila.getString(0) + "                                               "+fila.getString(1));
            }while (fila.moveToNext());
        }
        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ranking);
        lista.setAdapter(adapter);
    }

}
