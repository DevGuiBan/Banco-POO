import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    private static final BigDecimal TAXA_SAQUE = new BigDecimal("5.00");

    public ContaCorrente(String nome, String email, String cpf) {
        super(nome, email, cpf, true, false);
    }

    @Override
    public void exibirConta(){
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║             Informação de Conta              ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("║  [Nome]  ⇨ " + getNome());
        System.out.println("║  [Tipo]  ⇨ Corrente");
        System.out.println("║  [CPF]   ⇨ " + getCpf());
        System.out.println("║  [Email] ⇨ " + getEmail());
        System.out.println("║  [Saldo] ⇨ " + getSaldo().toString());
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║                                              ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    @Override
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            adicionarSaldo(valor);
            System.out.println("Depósito de " + valor + " realizado com sucesso!");
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal valorTotal = valor.add(TAXA_SAQUE);
            if (getSaldo().compareTo(valorTotal) >= 0) {
                subtrairSaldo(valorTotal);
                System.out.println("Saque de " + valor + " realizado com sucesso com taxa de " + TAXA_SAQUE + "!");
            } else {
                System.out.println("Saldo insuficiente para o saque e a taxa.");
            }
        } else {
            System.out.println("O valor do saque deve ser positivo.");
        }

    }
}