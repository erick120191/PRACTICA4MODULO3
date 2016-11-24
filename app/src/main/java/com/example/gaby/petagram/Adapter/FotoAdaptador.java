package com.example.gaby.petagram.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaby.petagram.Mascota;
import com.example.gaby.petagram.R;

import java.util.ArrayList;

/**
 * Created by gaby on 9/11/2016.
 */
public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder>{

    ArrayList<Mascota> fotosLista;
    Activity activity;

    public FotoAdaptador(ArrayList<Mascota> fotos,Activity activity){
        this.fotosLista = fotos;
        this.activity = activity;
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);

        return new FotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FotoViewHolder holder, int position) {
        final Mascota foto = fotosLista.get(position);

        holder.foto.setImageResource(foto.getImagen());
        holder.likes.setText(String.valueOf(foto.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return fotosLista.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView likes;

        public FotoViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.ivPerroPerfil);
            likes = (TextView) itemView.findViewById(R.id.tvConteoLikesPerfil);
        }
    }
}
