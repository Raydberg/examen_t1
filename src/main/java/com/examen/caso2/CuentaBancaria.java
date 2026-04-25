package com.examen.caso2;

public class CuentaBancaria {

    private double saldo;

    // esta variable es static ya que necesitamos contar
    // las cuentas que se han creado en total, no por objeto
    private static int totalCuentas = 0;

    // constructor, aqui damos el saldo inicial a la cuenta
    // si alguien mete un saldo negativo se rechaza
    public CuentaBancaria(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("el saldo inicial no puede ser negativo");
        }
        this.saldo = saldoInicial;
        totalCuentas++;
    }

    // aquí depositamos plata, pero primero revisamos que el monto tenga sentido
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("no se puede depositar cero o menos");
        }
        saldo += monto;
        System.out.println("se deposito " + monto + " soles. ahora tienes: " + saldo);
    }

    // aqui retiramos, revisamos que haya suficiente saldo antes de descontar
    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("no se puede retirar cero o menos");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("no tienes suficiente saldo para retirar eso");
        }
        saldo -= monto;
        System.out.println("se retiro " + monto + " soles. te queda: " + saldo);
    }

    // muestra cuanto hay en la cuenta
    public void mostrarSaldo() {
        System.out.println("saldo actual: " + saldo + " soles");
    }

    public double getSaldo() {
        return saldo;
    }

    // como totalCuentas es static se llama desde la clase, no desde un objeto
    public static void mostrarTotalCuentas() {
        System.out.println("en total se crearon " + totalCuentas + " cuentas");
    }
}