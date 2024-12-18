package com.example.cuentabancaria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Definir las variables para los controles de la interfaz
    private EditText etMonto;
    private Button btnConsultarSaldo, btnDepositar, btnRetirar, btnTransferir;
    private TextView tvResultado;

    // Crear una cuenta bancaria
    private CuentaBancaria cuenta1 = new CuentaBancaria("12345", "Carlos Lemos", 1000.0, "Ahorro");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        etMonto = findViewById(R.id.etMonto);
        btnConsultarSaldo = findViewById(R.id.btnConsultarSaldo);
        btnDepositar = findViewById(R.id.btnDepositar);
        btnRetirar = findViewById(R.id.btnRetirar);
        btnTransferir = findViewById(R.id.btnTransferir);
        tvResultado = findViewById(R.id.tvResultado);

        // Configurar el botón para consultar saldo
        btnConsultarSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResultado.setText(cuenta1.consultarSaldo());
            }
        });

        // Configurar el botón para depositar dinero
        btnDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double monto = obtenerMonto();
                if (monto > 0) {
                    cuenta1.depositar(monto);
                    tvResultado.setText("Depósito realizado. " + cuenta1.consultarSaldo());
                } else {
                    tvResultado.setText("Monto inválido.");
                }
            }
        });

        // Configurar el botón para retirar dinero
        btnRetirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double monto = obtenerMonto();
                if (monto > 0) {
                    cuenta1.retirar(monto);
                    tvResultado.setText("Retiro realizado. " + cuenta1.consultarSaldo());
                } else {
                    tvResultado.setText("Monto inválido o saldo insuficiente.");
                }
            }
        });

        // Configurar el botón para transferir dinero
        btnTransferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double monto = obtenerMonto();
                if (monto > 0) {
                    // En este caso, la transferencia es a la misma cuenta para simplificar
                    CuentaBancaria cuentaDestino = new CuentaBancaria("67890", "Ana Perez", 500.0, "Corriente");
                    cuenta1.transferir(cuentaDestino, monto);
                    tvResultado.setText("Transferencia realizada. " + cuenta1.consultarSaldo());
                } else {
                    tvResultado.setText("Monto inválido o saldo insuficiente.");
                }
            }
        });
    }

    // Método para obtener el monto del EditText y convertirlo a double
    private double obtenerMonto() {
        try {
            return Double.parseDouble(etMonto.getText().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
