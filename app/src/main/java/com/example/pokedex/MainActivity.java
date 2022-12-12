package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botonJugar = findViewById(R.id.botonJugar);
        botonJugar.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        Button b = (Button) view;

        if (b.getId() == R.id.botonJugar ) {
            //Obrim la pokedes  amb el Intent

            Intent intent = new Intent(this, pokedex.class);  //.class és l'arxiu java compilat

            startActivity(intent);
        }


    }
}