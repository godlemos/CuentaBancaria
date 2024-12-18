package com.example.cuentabancaria;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Espera 3 segundos antes de redirigir a la actividad de registro
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent para abrir la actividad de registro
                Intent intent = new Intent(SplashActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();  // Finaliza SplashActivity para que no se quede en el stack de actividades
            }
        }, 3000);  // 3000 milisegundos = 3 segundos
    }
}
