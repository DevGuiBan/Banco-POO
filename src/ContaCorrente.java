import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    private BigDecimal limite = BigDecimal.ZERO;
    private BigDecimal saldoComLimite = getSaldo().add(limite);

    public ContaCorrente(UsuarioCliente usuario) {
        super(usuario);
        this.limite = BigDecimal.valueOf(500.0);
        DadosDoBanco.ContaCorrente.add(this);
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    @Override
    protected void depositar(BigDecimal valor) {
            BigDecimal temp = BigDecimal.valueOf(500.0).subtract(getLimite());
            if(temp.compareTo(BigDecimal.ZERO) == 0) {
                setSaldo(getSaldo().add(valor));
            }else if(temp.compareTo(BigDecimal.ZERO) > 0) {
                setLimite(BigDecimal.valueOf(500.0));
                setSaldo(valor.subtract(temp));
            }
    }

    @Override
    protected void tranferir(BigDecimal valor, Conta destino) {
        if (saldoComLimite.compareTo(valor) < 0) {
            System.out.printf("Saldo insuficiente!");
        } else if (valor.compareTo(getSaldo()) >= 0) {
            BigDecimal temp = valor.subtract(getSaldo());
            setSaldo(BigDecimal.ZERO);
            setLimite(getLimite().subtract(temp));
            destino.depositar(valor);
        } else if (valor.compareTo(getSaldo()) < 0) {
            setSaldo(getSaldo().subtract(valor));
            destino.depositar(valor);
        }
    }

    @Override
    protected void retirar(BigDecimal valor) {
        if (saldoComLimite.compareTo(valor) < 0) {
            System.out.printf("Saldo insuficiente!");
        } else if (valor.compareTo(getSaldo()) >= 0) {
            BigDecimal temp = valor.subtract(getSaldo());
            setSaldo(BigDecimal.ZERO);
            setLimite(getLimite().subtract(temp));
        } else if (valor.compareTo(getSaldo()) < 0) {
            setSaldo(getSaldo().subtract(valor));
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