package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

public class PublishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText txtPrice;
        Switch swtFree;
        ImageButton btnBackPublish;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        txtPrice = (EditText) findViewById(R.id.txtPrice);
        swtFree = (Switch) findViewById(R.id.swtFree);
        btnBackPublish = (ImageButton) findViewById(R.id.btnBackPublish);

        swtFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (swtFree.isChecked()){
                    txtPrice.setEnabled(false);
                }else {
                    txtPrice.setEnabled((true));
                }
            }
        });

        btnBackPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}