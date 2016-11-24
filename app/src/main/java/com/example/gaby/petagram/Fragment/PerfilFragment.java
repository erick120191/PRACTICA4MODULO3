package com.example.gaby.petagram.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaby.petagram.Adapter.FotoAdaptador;
import com.example.gaby.petagram.Mascota;
import com.example.gaby.petagram.R;

import java.util.ArrayList;

/**
 * Created by gaby on 6/11/2016.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> perfiles;
    RecyclerView listaFotos;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaFotos = (RecyclerView) v.findViewById(R.id.rvPerfiles);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaFotos.setLayoutManager(glm);

        inicializarLista();

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        System.out.println("tamaño de la lista de fotos: " + perfiles.size());
        FotoAdaptador fotoAdaptador = new FotoAdaptador(perfiles,getActivity());
        listaFotos.setAdapter(fotoAdaptador);
    }

    public void inicializarLista(){

        perfiles = new ArrayList<>();

        perfiles.add(new Mascota("4", R.drawable.uno));
        perfiles.add(new Mascota("3", R.drawable.dos));
        perfiles.add(new Mascota("6",R.drawable.tres));
        perfiles.add(new Mascota("12", R.drawable.cuatro));
        perfiles.add(new Mascota("12", R.drawable.cinco));
    }

}
