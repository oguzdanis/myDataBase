package com.example.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Veritabanini olusturma

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Arabalar",MODE_PRIVATE,null);

            database.execSQL("CREATE TABLE IF NOT EXISTS Arabalar (Marka VARCHAR,Model VARCHAR,Yil INT(4))");

            //INSERT INTO
            //database.execSQL("INSERT INTO Arabalar (Marka,Model,Yil) Values ('Vw','Scirocco',2016)");

            //Delete
            //database.execSQL("DELETE from Arabalar where Marka='Seat'");

            //UPDATE
            //database.execSQL("UPDATE Arabalar SET Model='Golf' WHERE Model='Scirocco'");

            //SELECT *
            Cursor cursor = database.rawQuery("SELECT * FROM Arabalar",null);

            //Select yil=2017
            //Cursor cursor = database.rawQuery("SELECT Marka FROM Arabalar WHERE Yil>2015 AND Model='Leon'",null);

            //Cursor cursor = database.rawQuery("SELECT Marka FROM Arabalar WHERE Model LIKE '%e%' ",null);
            int MarkaIx = cursor.getColumnIndex("Marka");
            int ModelIx = cursor.getColumnIndex("Model");

            cursor.moveToFirst();

            while (cursor!=null){
                System.out.println("Marka :"+cursor.getString(MarkaIx));
                System.out.println("Model :"+cursor.getString(ModelIx));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
