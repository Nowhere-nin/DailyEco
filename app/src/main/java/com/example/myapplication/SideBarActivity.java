package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class SideBarActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Obtener el ImageButton para abrir el menú
        ImageButton imageButtonMenu = findViewById(R.id.imageButtonMenu);

        // Configurar la barra de acción
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        // Añadir un ImageView al Toolbar para abrir el menú desplegable
        ImageView imageViewMenu = findViewById(R.id.imageViewMenu);
        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });
        */

        // Configurar el clic en el ImageButton para abrir el menú
        imageButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });

        /*
        // Configurar el ActionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        */

        // Obtener el TextView para abrir el menú
        TextView textOpenMenu = findViewById(R.id.textOpenMenu);

        // Configurar el clic en el TextView para abrir el menú
        textOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir el menú lateral
                if (!drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Manejar clics en el ícono de hamburguesa en la barra de acción
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}