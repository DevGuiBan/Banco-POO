import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Conta {

    private int numero;
    private int agencia;
    private BigDecimal saldo;
    List<UsuarioCliente> usuarioCliente = new ArrayList<UsuarioCliente>();

    protected Conta(UsuarioCliente usuario) {
        Random aleatorio = new Random();
        this.numero = aleatorio.nextInt(10000) + 10000;
        this.agencia = 3451;
        this.saldo = BigDecimal.ZERO;
        usuarioCliente.add(usuario);
    }

    protected int getNumero() {
        return numero;
    }

    protected int getAgencia() {
        return agencia;
    }

    protected BigDecimal getSaldo() {
        return saldo;
    }

    protected void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    protected void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    protected void tranferir(BigDecimal valor, Conta destino) {
        if (this.saldo.compareTo(valor) < 0){
            System.out.printf("Saldo insuficiente!");
        }else{
            this.saldo = this.saldo.subtract(valor);
            destino.depositar(valor);
        }
    }

    protected void retirar(BigDecimal valor) {
        if (this.saldo.compareTo(valor) < 0) {
            System.out.printf("Saldo insuficiente!");
        }else{
            this.saldo = this.saldo.subtract(valor);
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", " + usuarioCliente +
                '}';
    }
}
