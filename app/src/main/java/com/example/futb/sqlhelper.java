package com.example.futb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlhelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de usuarios
    String sqlCreate="CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT, puntos INTEGER)";

    public sqlhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //se ejecuta la sentencia SQL de creacion de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        /*NOTA: por simplicidad del ejemplo aqui utilizamos directamente la opción de
         *       eliminar la tabla anterior y crearla de nuevo vacia con el nuevo formato.
         *       Sin embargo lo normal será que haya que migrar datos de la tabla antigua
         *       a la nueva, por lo que este método deberia ser más elaborada-
         *
         * se elimina la version anterior de la tabla*/
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        //se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }
}
