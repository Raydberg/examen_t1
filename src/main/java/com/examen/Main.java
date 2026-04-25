package com.examen;

import com.examen.caso2.CuentaBancaria;

public class Main {
    public static void main(String[] args) {

        // creo 3 cuentas con sus saldos iniciales
        CuentaBancaria cuentaAhorros = new CuentaBancaria(850);
        CuentaBancaria cuentaCorriente = new CuentaBancaria(1200);
        CuentaBancaria cuentaNueva = new CuentaBancaria(300);

        CuentaBancaria.mostrarTotalCuentas();

        // pruebo depositar y retirar normalmente
        try {
            cuentaAhorros.depositar(150);
            cuentaAhorros.retirar(80);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        // intento retirar mas de lo que hay
        try {
            cuentaCorriente.retirar(9999);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        // intento depositar un monto que no tiene sentido
        try {
            cuentaNueva.depositar(-20);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        // veo como quedaron los saldos
        cuentaAhorros.mostrarSaldo();
        cuentaCorriente.mostrarSaldo();
        cuentaNueva.mostrarSaldo();
    }
}