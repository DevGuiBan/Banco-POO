public class ContaPoupanca extends Conta{

    public ContaPoupanca(UsuarioCliente usuario) {
        super(usuario);
    }

    @Override
    public String toString() {
        return "Conta Poupança {" +
                "numero=" + getNumero() +
                ", agencia=" + getAgencia() +
                ", saldo=" + getSaldo() +
                ", " + usuarioCliente +
                '}';
    }
}