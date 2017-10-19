package com.example.kelly.galletas.ProveedorContenido;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AlumnoFP on 18/10/2017.
 */

public class DBHelperGalletas extends SQLiteOpenHelper {
    public DBHelperGalletas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelperGalletas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +
            Contrato.Galleta.NOMBRE_TABLA +
            "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contrato.Galleta.MARCA + " TEXT, " +
                Contrato.Galleta.STOCK + " INTEGER " +
            ");"

        );

        inicializar(db);

    }

    private void inicializar(SQLiteDatabase db) {
        db.execSQL("INSERT INTO " +
                Contrato.Galleta.NOMBRE_TABLA +
                "( " +
                Contrato.Galleta.MARCA + "," +
                Contrato.Galleta.STOCK +
                ") VALUES ('Bandama', 23)," +
                "('Tirma', 2)," +
                "('Cuetara', 122)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contrato.Galleta.NOMBRE_TABLA);
        onCreate(db);
    }
}
