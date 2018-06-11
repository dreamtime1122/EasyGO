package com.example.willy.easy_go;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseTest extends SQLiteOpenHelper{
    public  static  final String PUT_THING = "create table Put_Find("
            + "id integer primary key autoincrement,"
            + "Thing text,"
            + "S_where text)";
    private Context mContext;

    public  DatabaseTest(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){ //修改database的constructor
        super(context,name,factory,version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(PUT_THING);
        Toast.makeText(mContext,"Create Succeeded",Toast.LENGTH_SHORT).show();
    }
    @Override
    public  void onUpgrade(SQLiteDatabase db , int oldversion,int newversion){

    }
}
