
package segundoparcial_ing_grupo18;


public class Cuenta {
    private String id;
    private double saldo;

    public Cuenta(String id, double saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositarDinero(double monto) {
        this.saldo += monto;
    }

    public void retirarDinero(double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("Saldo insuficiente para retirar $" + monto);
        }
        this.saldo -= monto;
    }

    public void transferirDinero(Cuenta destino, double monto) throws Exception {
        if (destino == null) {
            throw new Exception("La cuenta destino no puede ser nula.");
        }
        this.retirarDinero(monto);
        destino.depositarDinero(monto);
    }

    public boolean CuentasDiferentes(Cuenta otra) {
        return this != otra;
    }

    public void OperacionTildada(int milisegundos) throws InterruptedException {
        Thread.sleep(milisegundos);
    }

    @Override
    public String toString() {
        return "Cuenta ID: " + id + " | Saldo: $" + saldo;
    }
}
