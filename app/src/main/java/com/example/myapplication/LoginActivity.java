package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify();
            }
        });
    }

    public void verify(){
        String errorContainer = "";
        Toast error = Toast.makeText(this, "", Toast.LENGTH_LONG);
        Intent landingActivity = new Intent(this, LandingActivity.class);

        if (!edtEmail.getText().toString().isEmpty()){
            if (!edtEmail.getText().toString().equals("correo@gmail.com")){
                errorContainer += "Debe ingresar un correo válido y registrado anteriormente";
            }else if(!edtPassword.getText().toString().equals("")){
                if(!edtPassword.getText().toString().equals("123456")){
                    errorContainer += "Contraseña incorrecta";
                }
            }else{
                errorContainer += "Ingrese una contraseña";
            }
        }else{
            errorContainer += "No debe dejar campos en blanco";
        }

        if (!errorContainer.equals("")){
            error.setText(errorContainer);
            error.show();
        }else {
            startActivity(landingActivity);
        }
    }
}