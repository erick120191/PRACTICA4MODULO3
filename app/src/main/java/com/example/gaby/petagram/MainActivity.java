package com.example.gaby.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.gaby.petagram.Adapter.ContactoAdaptador;
import com.example.gaby.petagram.Adapter.PageAdapter;
import com.example.gaby.petagram.Fragment.PerfilFragment;
import com.example.gaby.petagram.Fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        ((TextView) findViewById(R.id.toolbar_title)).setText("Petagram");
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();


        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList <Fragment> agregarFragments(){
        ArrayList <Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mContato:
                Intent intent = new Intent(this, contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                Intent i = new Intent(this, acerca_de.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    public void irSegundaActividad(View view){
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);
    }

}

