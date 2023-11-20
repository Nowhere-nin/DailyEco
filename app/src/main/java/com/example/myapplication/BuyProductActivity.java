package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class BuyProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);

        ImageButton btnBackBuy = (ImageButton) findViewById(R.id.btnBackBuy);

        TextView txtProductNameBuy = (TextView) findViewById(R.id.txtProductNameBuy);

        txtProductNameBuy.setText(getIntent().getExtras().getString("Product"));

        btnBackBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}