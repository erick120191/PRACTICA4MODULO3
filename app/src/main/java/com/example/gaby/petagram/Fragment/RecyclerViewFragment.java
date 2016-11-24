package com.example.gaby.petagram.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaby.petagram.Adapter.ContactoAdaptador;
import com.example.gaby.petagram.Mascota;
import com.example.gaby.petagram.R;

import java.util.ArrayList;

/**
 * Created by gaby on 3/11/2016.
 */
public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();

        return v;
    }

    public ContactoAdaptador adaptador;
    public void inicializaAdaptador(){
        adaptador = new ContactoAdaptador(mascotas,getActivity());
        listaContactos.setAdapter(adaptador);
    }


    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bobby", R.drawable.golden));
        mascotas.add(new Mascota("Poncho", R.drawable.boxer));
        mascotas.add(new Mascota("Fifi", R.drawable.pinche));
        mascotas.add(new Mascota("Zeus", R.drawable.pastor));
        mascotas.add(new Mascota("Hercules", R.drawable.labrador));
        mascotas.add(new Mascota("Candy", R.drawable.perro));
    }
}
