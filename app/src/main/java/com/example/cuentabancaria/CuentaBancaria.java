package com.example.cuentabancaria;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private String tipoCuenta;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldo, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    // Método para consultar el saldo
    public String consultarSaldo() {
        return "El saldo disponible es: $" + saldo;
    }

    // Método para depositar dinero
    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
            return true;
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
            return false;
        }
    }

    // Método para retirar dinero
    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Saldo actual: $" + saldo);
            return true;
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
            return false;
        } else {
            System.out.println("El monto a retirar debe ser positivo.");
            return false;
        }
    }

    // Método para transferir dinero a otra cuenta
    public boolean transferir(CuentaBancaria cuentaDestino, double monto) {
        if (cuentaDestino != null && this.retirar(monto)) {
            cuentaDestino.depositar(monto);
            System.out.println("Transferencia exitosa de $" + monto + " a la cuenta de " + cuentaDestino.getTitular());
            return true;
        } else {
            System.out.println("Transferencia fallida.");
            return false;
        }
    }

    // Getters y setters (opcional)
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }
}
