package com.example.projekt4;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText producent;
    EditText model;
    EditText wersja,strona;
    Button www,anuluj,zapisz;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Bundle tobolek = getIntent().getExtras();                   //Pobranie wartości z aktywności wywołującej
        long id = tobolek.getLong("id");

        String [] arg={id +""};
        String[] kolumny= {PomocnikBD.ID,PomocnikBD.KOLUMNA1,PomocnikBD.KOLUMNA2};

        Cursor odbior=getContentResolver().query(MojDiler.URI_ZAWARTOSCI,kolumny,"_id=?",arg,null);
        odbior.moveToFirst();

        producent =findViewById(R.id.editText);
        model = findViewById(R.id.editText2);
        wersja = findViewById(R.id.editText3);
        strona = findViewById(R.id.editText4);
        producent.setText(odbior.getString(0));
        model.setText(odbior.getString(1));
        wersja.setText(odbior.getString(2));

        www=findViewById(R.id.button);
        anuluj=findViewById(R.id.button2);
        zapisz=findViewById(R.id.button3);
    }

    public void onWww(View view){
        String adres = strona.getText().toString();
        if(adres.startsWith("http://")) {
            Intent zamiarPrzegladarki = new Intent("android.intent.action.VIEW", Uri.parse(adres));
            startActivity(zamiarPrzegladarki);
        }
    }
    public void onAnuluj(View view){
        finish();
    }
    public void onZapisz(View view){

    }
}
