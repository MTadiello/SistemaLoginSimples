package com.cursoandroidudemy.telalogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RepositoryUsers extends SQLiteOpenHelper {

    private static final String NOME_DB = "db_users";
    private static final int VERSION = 1;

    public RepositoryUsers(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = " create table usuario(\n" +
                "            id INTEGER PRIMARY KEY,\n" +
                "            apelido TEXT NOT NULL,\n" +
                "            email TEXT NOT NULL,\n" +
                "            senha INTEGER NOT NULL" +
                "    )";

        sqLiteDatabase.execSQL(sql);
        Log.i("usuario","sql criação tabela usuario" + sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void adicionarUsuario(Usuario user){

        ContentValues contentValues = new ContentValues();
        contentValues.put("email",user.getEmail());
        contentValues.put("apelido",user.getApelido());
        contentValues.put("senha",user.getSenha());


        getWritableDatabase().insert("usuario",null,contentValues);



    }

    public void deletarUsuario(Usuario usuario){

        String sql = " delete from usuario  where id = " + usuario.getId();


        Log.i("usuario","sql delete " + sql);
        getWritableDatabase().execSQL(sql);

    }

    public List<Usuario> listarUsuario(){

        List<Usuario> listarUsuario = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select id, email, apelido, senha from usuario",null);
        cursor.moveToFirst();

        for(int i=0; i < cursor.getCount(); i++){

            Usuario user = new Usuario();
            user.setId(cursor.getInt(0));
            user.setEmail(cursor.getString(1));
            user.setApelido(String.valueOf(cursor.getString(2)));
            user.setSenha(String.valueOf(cursor.getInt(3)));


            listarUsuario.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return listarUsuario;
    }
}
