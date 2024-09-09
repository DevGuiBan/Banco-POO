import java.math.BigDecimal;
import java.util.Scanner;

public class Banco {

    Scanner sc = new Scanner(System.in);
    Conta[] contasDoBanco = new Conta[1];

    public void captarContaParaOBanco(String tipoDeConta) {
        String nomeConta;
        String cpfConta;
        String emailConta;

        try {
            System.out.println(">>> Digite o nome do contato: ");
            nomeConta = sc.nextLine();
            System.out.println(">>> Digite o CPF: ");
            cpfConta = sc.nextLine();
            System.out.println(">>> Digite o email: ");
            emailConta = sc.nextLine();

            if (existeContaComCpfETipo(cpfConta, tipoDeConta)) {
                throw new BancoException("Já existe uma conta " + tipoDeConta + " com esse CPF.");
            }

            if (tipoDeConta.equals("corrente")) {
                ContaCorrente contaCriadaParaOBanco = new ContaCorrente(nomeConta, emailConta, cpfConta);
                adicionarContaNoBanco(contaCriadaParaOBanco);
                contaCriadaParaOBanco.exibirConta();
                System.out.println("Conta corrente criada com sucesso!");
            } else if (tipoDeConta.equals("poupanca")) {
                ContaPoupanca contaCriadaParaOBanco = new ContaPoupanca(nomeConta, emailConta, cpfConta);
                adicionarContaNoBanco(contaCriadaParaOBanco);
                contaCriadaParaOBanco.exibirConta();
                System.out.println("Conta poupança criada com sucesso!");
            } else {
                throw new BancoException("Tipo de conta inválido.");
            }
        } catch (BancoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void adicionarContaNoBanco(Conta conta) {
        for (int i = 0; i < contasDoBanco.length; i++) {
            if (contasDoBanco[i] == null) {
                contasDoBanco[i] = conta;
                aumentarONumeroDeContasDoBanco();
                return;
            }
        }
    }

    public void aumentarONumeroDeContasDoBanco() {
        Conta[] contasAumentado = new Conta[contasDoBanco.length + 1];
        for (int i = 0; i < contasDoBanco.length; i++) {
            contasAumentado[i] = contasDoBanco[i];
        }
        contasDoBanco = contasAumentado;
    }

    private boolean existeContaComCpfETipo(String cpf, String tipoDeConta) {
        for (Conta conta : contasDoBanco) {
            if (conta != null && conta.getCpf().equals(cpf)) {
                if (tipoDeConta.equals("corrente") && conta instanceof ContaCorrente) {
                    return true;
                } else if (tipoDeConta.equals("poupanca") && conta instanceof ContaPoupanca) {
                    return true;
                }
            }
        }
        return false;
    }

    public void exibirTodasAsConta() {
        for (int i = 0; i < contasDoBanco.length; i++) {
            if (contasDoBanco[i] != null) {
                contasDoBanco[i].exibirConta();
            }
        }
    }

    public void exibirContaCorrente() {
        for (int i = 0; i < contasDoBanco.length; i++) {
            if (contasDoBanco[i] != null && contasDoBanco[i] instanceof ContaCorrente) {
                contasDoBanco[i].exibirConta();
            }
        }
    }

    public void exibirContaPoupanca() {
        for (int i = 0; i < contasDoBanco.length; i++) {
            if (contasDoBanco[i] != null && contasDoBanco[i] instanceof ContaPoupanca) {
                contasDoBanco[i].exibirConta();
            }
        }
    }

    public void removerConta(String tipoDeConta) {
        try {
            System.out.println(">>> Digite o CPF da Conta Para Remoção:");
            String cpf = sc.nextLine();
            boolean removed = false;

            for (int i = 0; i < contasDoBanco.length; i++) {
                if (contasDoBanco[i] != null && contasDoBanco[i].getCpf().equals(cpf)) {
                    if (tipoDeConta.equals("corrente") && contasDoBanco[i] instanceof ContaCorrente) {
                        contasDoBanco[i] = null;
                        reorganizarContas();
                        removed = true;
                        System.out.println("Conta corrente removida com sucesso!");
                        break;
                    }
                    if (tipoDeConta.equals("poupanca") && contasDoBanco[i] instanceof ContaPoupanca) {
                        contasDoBanco[i] = null;
                        reorganizarContas();
                        removed = true;
                        System.out.println("Conta poupança removida com sucesso!");
                        break;
                    }
                }
            }

            if (!removed) {
                throw new BancoException("Conta não encontrada ou tipo incorreto.");
            }
        } catch (BancoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reorganizarContas() {
        for (int i = 0; i < contasDoBanco.length - 1; i++) {
            if (contasDoBanco[i] == null && contasDoBanco[i + 1] != null) {
                contasDoBanco[i] = contasDoBanco[i + 1];
                contasDoBanco[i + 1] = null;
            }
        }
    }

    public void editarConta(String tipoDeConta, String campoParaEditar) {
        try {
            System.out.println(">>> Digite o CPF da Conta Para Edição:");
            String cpf = sc.nextLine();
            boolean encontrado = false;

            for (int i = 0; i < contasDoBanco.length; i++) {
                if (contasDoBanco[i] != null && contasDoBanco[i].getCpf().equals(cpf)) {
                    if ((tipoDeConta.equals("corrente") && contasDoBanco[i] instanceof ContaCorrente) ||
                            (tipoDeConta.equals("poupanca") && contasDoBanco[i] instanceof ContaPoupanca)) {

                        if (campoParaEditar.equals("nome")) {
                            System.out.println("Digite o novo nome:");
                            String novoNome = sc.nextLine();
                            contasDoBanco[i].setNome(novoNome);
                            System.out.println("Nome atualizado com sucesso!");
                        } else if (campoParaEditar.equals("email")) {
                            System.out.println("Digite o novo email:");
                            String novoEmail = sc.nextLine();
                            contasDoBanco[i].setEmail(novoEmail);
                            System.out.println("Email atualizado com sucesso!");
                        } else {
                            throw new BancoException("Campo inválido para edição.");
                        }
                        encontrado = true;
                        break;
                    }
                }
            }

            if (!encontrado) {
                throw new BancoException("Conta não encontrada ou tipo incorreto.");
            }
        } catch (BancoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void realizarOperacao(String tipoDeConta, String operacao) {
        try {
            System.out.println(">>> Digite o CPF da Sua Conta:");
            String cpf = sc.nextLine();

            Conta conta = buscarContaPorCpfETipo(cpf, tipoDeConta);

            if (conta != null) {
                if (operacao.equals("depositar")) {
                    System.out.println("Digite o valor a depositar:");
                    BigDecimal valor = sc.nextBigDecimal();
                    sc.nextLine();
                    conta.depositar(valor);

                } else if (operacao.equals("sacar")) {
                    System.out.println("Digite o valor a sacar:");
                    BigDecimal valor = sc.nextBigDecimal();
                    sc.nextLine();
                    conta.sacar(valor);

                } else if (operacao.equals("transferir")) {
                    System.out.println("Digite o CPF da conta de destino:");
                    String cpfDestino = sc.nextLine();
                    System.out.println("Digite o valor a transferir:");
                    BigDecimal valor = sc.nextBigDecimal();
                    sc.nextLine();

                    Conta contaDestino = buscarContaPorCpfETipo(cpfDestino, tipoDeConta);

                    if (contaDestino != null) {
                        conta.transferir(contaDestino, valor);
                    } else {
                        throw new BancoException("Conta de destino não encontrada.");
                    }
                } else {
                    throw new BancoException("Operação inválida.");
                }
            } else {
                throw new BancoException("Conta não encontrada ou tipo incorreto.");
            }
        } catch (BancoException e) {
            System.out.println(e.getMessage());
        }
    }

    private Conta buscarContaPorCpfETipo(String cpf, String tipoDeConta) {
        for (int i = 0; i < contasDoBanco.length; i++) {
            if (contasDoBanco[i] != null && contasDoBanco[i].getCpf().equals(cpf)) {
                if ((tipoDeConta.equals("corrente") && contasDoBanco[i] instanceof ContaCorrente) ||
                        (tipoDeConta.equals("poupanca") && contasDoBanco[i] instanceof ContaPoupanca)) {
                    return contasDoBanco[i];
                }
            }
        }
        return null;
    }
}
