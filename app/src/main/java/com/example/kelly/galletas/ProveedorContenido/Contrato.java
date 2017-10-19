package com.example.kelly.galletas.ProveedorContenido;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by AlumnoFP on 18/10/2017.
 */

public class Contrato {
    public final static String AUTHORITY = "com.example.kelly.galletas.ProveedorContenido.Proveedor";

    public static class Galleta implements BaseColumns {
        public final static String NOMBRE_TABLA = "Galleta";
        public final static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + NOMBRE_TABLA);

        public final static String MARCA = "Marca";
        public final static String STOCK = "Stock";

    }
}
