package com.example.gaby.petagram.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaby.petagram.Mascota;
import com.example.gaby.petagram.R;

import java.util.ArrayList;

/**
 * Created by gaby on 26/10/2016.
 */
// Ayuda crear un objeto, es necesaria porque dara logica y vida a los View
public class ContactoAdaptador
        extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Mascota> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Mascota> contactos, Activity activity){
        this.contactos = contactos;
        this.activity  = activity;
    }


    //Inflara el layout y lo pasara al viewholder para que obtenda los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia a cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Mascota contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getImagen());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());


        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contacto.setRaiting(contacto.getRaiting()+1);
                contactoViewHolder.tvNumeroCV.setText(String.valueOf(contacto.getRaiting()));
                Toast.makeText(activity, "Diste Like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista de contactos

        return contactos.size();
    }

    public  static  class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageView btnLike;
        private TextView tvNumeroCV;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike = (ImageView) itemView.findViewById(R.id.btnLike);
            tvNumeroCV = (TextView) itemView.findViewById(R.id.tvNumeroCV);
        }
    }
}
