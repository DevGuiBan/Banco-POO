import java.math.BigDecimal;

public abstract class Conta {
    private int id = 0;
    private String nome;
    private String email;
    private String cpf;
    private BigDecimal saldo;
    private final boolean contaCorrente;
    private final boolean contaPoupanca;


    //Contrutor
    public Conta(String nome, String email, String cpf, Boolean contaCorrente, Boolean contaPoupanca) {
        this.id = id + 1;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.saldo = BigDecimal.ZERO;
        this.contaCorrente = contaCorrente;
        this.contaPoupanca = contaPoupanca;
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    //Metodos
    protected void adicionarSaldo(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    protected void subtrairSaldo(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }

    public void transferir(Conta destino, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && saldo.compareTo(valor) >= 0) {
            this.saldo = this.saldo.subtract(valor);
            destino.saldo = destino.saldo.add(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso!");
        } else if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("O valor da transferência deve ser positivo.");
        } else {
            System.out.println("Saldo insuficiente para a transferência.");
        }
    }

    public abstract void exibirConta();

    public abstract void depositar(BigDecimal valor);

    public abstract void sacar(BigDecimal valor);

}
