package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class LandingActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Button btnBuyLanding1 = (Button) findViewById(R.id.btnBuyLanding1);
        Button btnBuyLanding2 = (Button) findViewById(R.id.btnBuyLanding2);
        Button btnBuyLanding3 = (Button) findViewById(R.id.btnBuyLanding3);
        Button btnBuyLanding4 = (Button) findViewById(R.id.btnBuyLanding4);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Obtener el ImageButton para abrir el menú
        ImageButton imageButtonMenu = findViewById(R.id.imageButtonMenu);

        // Configurar la barra de acción
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar el clic en el ImageButton para abrir el menú
        imageButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });

        btnBuyLanding1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyProduct(1);
            }
        });

        btnBuyLanding2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyProduct(2);
            }
        });

        btnBuyLanding3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyProduct(3);
            }
        });

        btnBuyLanding4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyProduct(4);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Manejar clics en los elementos de menú aquí
                int itemId = menuItem.getItemId();

                if (itemId == R.id.nav_publicar_productos) {
                    // Lógica para la opción "Publicar productos"
                    Intent intent = new Intent(LandingActivity.this, PublishActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.nav_escanear_codigos) {
                    // Lógica para la opción "Escanear códigos"
                } else if (itemId == R.id.nav_mis_codigos) {
                    // Lógica para la opción "Mis códigos"
                    Intent intent = new Intent(LandingActivity.this, MyCodesActivity.class);
                    startActivity(intent);
                } else if (itemId == R.id.nav_cerrar_sesion) {
                    // Lógica para la opción "Cerrar sesión"
                    // Por ejemplo, cerrar sesión y regresar a la actividad de inicio de sesión
                    Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Cierra la actividad actual para evitar que el usuario vuelva atrás
                }

                // Cerrar el menú después de hacer clic en un elemento
                drawer.closeDrawers();
                return true;
            }
        });


    }

    public void buyProduct(int position){
        int[] resourceId = {R.id.txtProductNameLanding1, R.id.txtProductNameLanding2, R.id.txtProductNameLanding3, R.id.txtProductNameLanding4};
        TextView txtProducName = (TextView) findViewById(resourceId[position-1]);
        Intent productActivity = new Intent(LandingActivity.this, BuyProductActivity.class);
        productActivity.putExtra("Product", txtProducName.getText());
        startActivity(productActivity);
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