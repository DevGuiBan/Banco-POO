import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta{

    private BigDecimal limite;

    public ContaCorrente(UsuarioCliente usuario) {
        super(usuario);
        limite = BigDecimal.valueOf(500.0);
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
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
    }
}
