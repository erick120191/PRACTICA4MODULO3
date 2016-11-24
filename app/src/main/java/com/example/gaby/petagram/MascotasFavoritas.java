package com.example.gaby.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaby.petagram.Adapter.ContactoAdaptador;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasFav;
    private RecyclerView listaMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ((TextView) findViewById(R.id.toolbar_title)).setText("Petagram");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quito imagen 5 estrellas
        ImageView img5Stars= (ImageView) findViewById(R.id.imagenDerecha);
        img5Stars.setVisibility(View.INVISIBLE);


        listaMascotasFav= (RecyclerView) findViewById(R.id.rvMascotasFavoritas);


        //GridLayoutManager lm = new GridLayoutManager(this,2);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFav.setLayoutManager(lm);

        inicializaListaMascotasFav();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        //crea objeto mascotaAdaptador para que reciba la lista y que pueda hacer lo configurado
        ContactoAdaptador adaptador = new ContactoAdaptador(mascotasFav,this);
        listaMascotasFav.setAdapter(adaptador);
    }

    public void inicializaListaMascotasFav(){
        mascotasFav = new ArrayList<Mascota>();

        mascotasFav.add(new Mascota("Poncho", R.drawable.boxer));
        mascotasFav.add(new Mascota("Fifi", R.drawable.pinche));
        mascotasFav.add(new Mascota("Zeus", R.drawable.pastor));
        mascotasFav.add(new Mascota("Hercules", R.drawable.labrador));
        mascotasFav.add(new Mascota("Candy", R.drawable.perro));

    }

}
