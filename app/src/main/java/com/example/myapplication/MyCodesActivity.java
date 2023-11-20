package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCodesActivity extends AppCompatActivity {

    ImageButton btnBackCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_codes);

        ImageView imvProductCode1 = (ImageView) findViewById(R.id.imvProductCode1);
        ImageView imvProductCode2 = (ImageView) findViewById(R.id.imvProductCode2);

        btnBackCodes = (ImageButton) findViewById(R.id.btnBackCodes);

        btnBackCodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imvProductCode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lookCode(1);
            }
        });

        imvProductCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lookCode(2);
            }
        });
    }

    public void lookCode(int position){
        int[] resourceId = {R.id.txtCodes1, R.id.txtCodes2};
        TextView txtCodeName = (TextView) findViewById(resourceId[position-1]);
        Intent codeActivity = new Intent(MyCodesActivity.this, CodeActivity.class);
        codeActivity.putExtra("Product", txtCodeName.getText());
        startActivity(codeActivity);
    }
}