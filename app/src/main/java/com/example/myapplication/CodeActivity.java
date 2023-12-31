package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        ImageButton btnBackCode1 = (ImageButton) findViewById(R.id.btnBackCode1);
        TextView txtCodeName = (TextView) findViewById(R.id.txtCodeName);

        txtCodeName.setText(getIntent().getExtras().getString("Product"));

        btnBackCode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}