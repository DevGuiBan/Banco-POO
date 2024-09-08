public class ContaPoupanca extends Conta{

    public ContaPoupanca(UsuarioCliente usuario) {
        super(usuario);
        DadosDoBanco.ContaPoupanca.add(this);
    }

    @Override
    public String toString() {
        return "Conta Poupança {" +
                "numero=" + getNumero() +
                ", agencia=" + getAgencia() +
                ", saldo=" + getSaldo() +
                ", " + usuarioCliente +
                '}';
        //return "CONTA POUPANÇA [ " + "Agência = " + getAgencia() + "  |  Conta = " + getNumero() + "  |  Saldo = " + getSaldo() + " ]";
    }
}