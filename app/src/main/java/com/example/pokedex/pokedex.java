package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;

public class pokedex extends AppCompatActivity implements View.OnClickListener {

    Integer numPokemon = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);



        RadioButton botoActivitat = findViewById(R.id.radioButtonVerde);
        botoActivitat.setOnClickListener(this);
        RadioButton botoMasInfo = findViewById(R.id.radioButtonAzul);
        botoMasInfo.setOnClickListener(this);

        Button anterior = findViewById(R.id.anterior);
        Button siguiente = findViewById(R.id.siguiente);


        anterior.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            Button view = (Button) v;
                                            if( view.getId() == R.id.anterior)
                                            {
                                                if (numPokemon > 1) {
                                                    numPokemon = numPokemon - 1;
                                                    inflarFragment();
                                                    }
                                            }
                                        }
                                    });

        siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button view = (Button) v;
                if( view.getId() == R.id.siguiente)
                {

                        numPokemon = numPokemon + 1;
                        inflarFragment();

                }
            }
        });

    }


    @Override
    public void onClick(View view) {
        RadioButton b = (RadioButton) view;

        if (b.getId() == R.id.radioButtonVerde ){
            inflarFragment();
        }

    }

    private void inflarFragment(){
        FragmentManager fm = getSupportFragmentManager();

        //if (fm.findFragmentById(R.id.linear1) == null) {
            Fragment fragment1 = new pokemon_Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("numPokemon", numPokemon);
            fragment1.setArguments(bundle);
            fm.beginTransaction().replace(R.id.linear1, fragment1).commit();
        //}
    }
}