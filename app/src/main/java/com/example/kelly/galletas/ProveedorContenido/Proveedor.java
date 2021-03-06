package com.example.kelly.galletas.ProveedorContenido;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.MimeTypeMap;

public class Proveedor extends ContentProvider {

    final int DATABASE_VERSION = 2;
    final String DATABASE_NAME = "Galletas.db";
    DBHelperGalletas dbHelper;

    final static int GALLETAS_ALL_REGS = 1;
    final static int GALLETAS_ONE_REG = 2;

    static UriMatcher mUriMatcher = new UriMatcher(0);
    private  static  final SparseArray<String> sMimeTypes;

    static {
        mUriMatcher.addURI(Contrato.AUTHORITY, Contrato.Galleta.NOMBRE_TABLA, GALLETAS_ALL_REGS);
        mUriMatcher.addURI(Contrato.AUTHORITY, Contrato.Galleta.NOMBRE_TABLA + "/#", GALLETAS_ONE_REG);

        sMimeTypes = new SparseArray<String>();

        sMimeTypes.put(GALLETAS_ALL_REGS, "vnd.android.cursor.dir/vnd." + Contrato.AUTHORITY + "." + Contrato.Galleta.NOMBRE_TABLA);
        sMimeTypes.put(GALLETAS_ONE_REG, "vnd.android.cursor.item/vnd." + Contrato.AUTHORITY + "." + Contrato.Galleta.NOMBRE_TABLA);
    }

    public Proveedor() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        dbHelper = new DBHelperGalletas(getContext(), DATABASE_NAME, null, DATABASE_VERSION);
        return (dbHelper == null ? false : true);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        switch (mUriMatcher.match(uri)) {
            case GALLETAS_ALL_REGS:
                if(TextUtils.isEmpty(sortOrder)) sortOrder = Contrato.Galleta._ID + " ASC";
                qb.setTables(Contrato.Galleta.NOMBRE_TABLA);
                break;
            case GALLETAS_ONE_REG:
                if(null == selection) selection = "";
                selection += Contrato.Galleta._ID + " = "
                        + uri.getLastPathSegment();
                qb.setTables(Contrato.Galleta.NOMBRE_TABLA);
                break;
        }
        Cursor c;
        c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
