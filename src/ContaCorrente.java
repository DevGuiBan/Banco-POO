import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    private BigDecimal limite = BigDecimal.ZERO;
    private BigDecimal saldoComLimite = BigDecimal.ZERO;

    public ContaCorrente(UsuarioCliente usuario) {
        super(usuario);
        this.limite = BigDecimal.valueOf(500.0);
        this.saldoComLimite = getSaldo().add(limite);
        DadosDoBanco.ContaCorrente.add(this);
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getSaldoComLimite() {
        return saldoComLimite;
    }

    @Override
    protected void depositar(BigDecimal valor) {
            BigDecimal temp = BigDecimal.valueOf(500.0).subtract(getLimite());
            if(temp.compareTo(BigDecimal.ZERO) == 0) {
                setSaldo(getSaldo().add(valor));
                System.out.println("\nO valor " + valor + " foi depositado com sucesso!");
                this.saldoComLimite = getSaldo().add(limite);
            }else if(temp.compareTo(BigDecimal.ZERO) > 0) {
                setLimite(BigDecimal.valueOf(500.0));
                setSaldo(valor.subtract(temp));
                System.out.println("\nO valor " + valor + " foi depositado com sucesso!");
                this.saldoComLimite = getSaldo().add(limite);
            }
    }

    @Override
    protected void tranferir(BigDecimal valor, Conta destino) {
        if (ContaCorrente.this.saldoComLimite.compareTo(valor) < 0) {
            System.out.println("Saldo insuficiente!\n");
        } else if (valor.compareTo(ContaCorrente.this.getSaldo()) >= 0) {
            BigDecimal temp = valor.subtract(getSaldo());
            setSaldo(BigDecimal.ZERO);
            setLimite(getLimite().subtract(temp));
            destino.depositar(valor);
            System.out.println("\nO valor " + valor + " foi transferido com sucesso para a conta: " + destino);
            this.saldoComLimite = getSaldo().add(limite);
        } else if (valor.compareTo(ContaCorrente.this.getSaldo()) < 0) {
            setSaldo(getSaldo().subtract(valor));
            destino.depositar(valor);
            System.out.println("\nO valor " + valor + " foi transferido com sucesso para a conta: " + destino);
            this.saldoComLimite = getSaldo().add(limite);
        }
    }

    @Override
    protected void retirar(BigDecimal valor) {
        if (saldoComLimite.compareTo(valor) < 0) {
            System.out.println("Saldo insuficiente!\n");
        } else if (valor.compareTo(getSaldo()) >= 0) {
            BigDecimal temp = valor.subtract(getSaldo());
            setSaldo(BigDecimal.ZERO);
            setLimite(getLimite().subtract(temp));
            System.out.println("\nO valor " + valor + " foi retirado com sucesso!");
            this.saldoComLimite = getSaldo().add(limite);
        } else if (valor.compareTo(getSaldo()) < 0) {
            setSaldo(getSaldo().subtract(valor));
            System.out.println("\nO valor " + valor + " foi retirado com sucesso!");
            this.saldoComLimite = getSaldo().add(limite);
        }
    }

    @Override
    public String toString() {
        return "Conta Corrente {" +
                "numero=" + getNumero() +
                ", agencia=" + getAgencia() +
                ", saldo=" + getSaldo() +
                ", limite=" + limite +
                ", " + usuarioCliente +
                '}';
        //return "CONTA CORRENTE [ " + "Agência = " + getAgencia() + "  |  Conta = " + getNumero() + "  |  Saldo = " + getSaldo() + "  |  Limite = " + limite + " ]";
    }
}