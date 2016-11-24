package com.example.gaby.petagram;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaby.petagram.Mail.SendMail;

public class contacto extends AppCompatActivity {

    TextInputEditText Nombre;
    TextInputEditText Correo;
    TextInputEditText Descripcion;
    Button Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Nombre      = (TextInputEditText) findViewById(R.id.nombreText);
        Correo      = (TextInputEditText) findViewById(R.id.correoText);
        Descripcion = (TextInputEditText) findViewById(R.id.descripcionText);
        Enviar      = (Button) findViewById(R.id.botonEnviar);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ((TextView) findViewById(R.id.toolbar_title)).setText("Petagram");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //quito imagen 5 estrellas
        ImageView img5Stars= (ImageView) findViewById(R.id.imagenDerecha);
        img5Stars.setVisibility(View.INVISIBLE);


    }

    public void sendEmail(View view){
        String nombre=Nombre.getText().toString().trim();
        String correo = Correo.getText().toString().trim();
        String comentario = Descripcion.getText().toString().trim();
        String subject="Comentario recibido de "+nombre+"   :)";
        SendMail sm = new SendMail(this,correo,subject,comentario);
        sm.execute();


        SendMail sm2 = new SendMail(this,correo,"Hola "+nombre+" un gusto en saludarte","Gracias por tu comentario, en breve te contestaremos, gracias ;)");
        sm2.execute();


        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
