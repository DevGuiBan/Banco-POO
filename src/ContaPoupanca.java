import java.math.BigDecimal;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String nome, String email, String cpf) {
        super(nome, email, cpf, false, true);
    }

    @Override
    public void exibirConta(){
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║             Informação de Conta              ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("║  [Nome]  ⇨ " + getNome());
        System.out.println("║  [Tipo]  ⇨ Poupança");
        System.out.println("║  [CPF]   ⇨ " + getCpf());
        System.out.println("║  [Email] ⇨ " + getEmail());
        System.out.println("║  [Saldo] ⇨ " + getSaldo().toString());
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║                                              ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    @Override
    public void depositar(BigDecimal valor) {

        BigDecimal bonus = valor.divide(new BigDecimal("1000")).multiply(new BigDecimal("5"));
        adicionarSaldo(getSaldo().add(valor).add(bonus));
        System.out.println("Depósito de " + valor + " realizado com sucesso. Bônus de " + bonus + " adicionado!");
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (getSaldo().compareTo(valor) >= 0) {
            subtrairSaldo(getSaldo().subtract(valor));
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }
}
