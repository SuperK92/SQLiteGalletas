package com.example.kelly.galletas.Galletas;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.kelly.galletas.ProveedorContenido.Contrato;
import com.example.kelly.galletas.R;

/**
 * Created by AlumnoFP on 18/10/2017.
 */

public class GalletasAdapter extends CursorAdapter {
    public GalletasAdapter(Context context) {
        super(context, null, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.galletas_item, parent, false);
        bindView(v, context, cursor);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String marca = cursor.getString(cursor.getColumnIndex(Contrato.Galleta.MARCA));
        int stock = cursor.getInt(cursor.getColumnIndex(Contrato.Galleta.STOCK));
        TextView textViewMarca = (TextView) view.findViewById(R.id.textViewMarca);
        TextView textViewStock = (TextView) view.findViewById(R.id.textViewStock);
        textViewMarca.setText(marca);
        textViewStock.setText(String.valueOf(stock));

    }
}
