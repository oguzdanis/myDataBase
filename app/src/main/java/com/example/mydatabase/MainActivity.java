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

        TextView tvmarka,tvmodel;
        tvmarka = (TextView)findViewById(R.id.tv_marka);
        tvmodel = (TextView)findViewById(R.id.tv_model);



//Veritabanini olusturma

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Arabalar",MODE_PRIVATE,null);

            database.execSQL("CREATE TABLE IF NOT EXISTS Arabalar (Marka VARCHAR,Model VARCHAR,Yil INT(4))");

            //INSERT INTO
            //database.execSQL("INSERT INTO Arabalar (Marka,Model,Yil) Values ('Seat','Leon',2017)");

            //SELECT
            Cursor cursor = database.rawQuery("SELECT * FROM Arabalar LIMIT 1",null);

            int MarkaIx = cursor.getColumnIndex("Marka");
            int ModelIx = cursor.getColumnIndex("Model");

            cursor.moveToFirst();

            while (cursor!=null){
                System.out.println("Marka :"+cursor.getString(MarkaIx));
                System.out.println("Model :"+cursor.getString(ModelIx));
                tvmarka.setText(cursor.getString(MarkaIx));
                tvmodel.setText(cursor.getString(ModelIx));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
