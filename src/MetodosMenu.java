import java.math.BigDecimal;
import java.util.Scanner;

public class MetodosMenu {

    protected static void adicionar() {
        Scanner input = new Scanner(System.in);

        boolean exibirAdicionar = true;

        UsuarioCliente cliente = null;

        while (exibirAdicionar) {
            System.out.println("\n\uD83D\uDFB4 MENU - ADICIONAR CLIENTES | CONTA");
            System.out.println(" [1] Adicionar Cliente");
            System.out.println(" [2] Adicionar Conta Corrente");
            System.out.println(" [3] Adicionar Conta Poupança");
            System.out.println(" [4] Sair");
            System.out.print("\uD83D\uDF82 Selecione a opção desejada: ");
            int escolha = input.nextInt();
            input.nextLine();

            String CPF = null;

            switch (escolha) {
                case 1:
                    if (DadosDoBanco.UsuarioCliente.isEmpty()) {
                        cliente = UsuarioCliente.adicionarCliente();
                        System.out.println("   \uD83D\uDDF8 CLIENTE ADICIONADO COM SUCESSO !!!");
                        cliente.toString();
                        break;
                    } else {
                        System.out.print("\n ￭ Digite o CPF do cliente: ");
                        CPF = input.nextLine();
                        boolean fim = true;
                        for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                            if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)) {
                                System.out.println("\n\ud83d\uddd9 O CPF digitado já está cadastrado!");
                                fim = false;
                                break;
                            }
                        }
                        if (fim) {
                            cliente = UsuarioCliente.adicionarCliente(CPF);
                            System.out.println("\n   \uD83D\uDDF8 CLIENTE ADICIONADO COM SUCESSO !!!");
                            cliente.toString();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()) {
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta corrente!"); // NÃO ESTÁ FUNCIONANDO
                        break;
                    } else {
                        System.out.print("\n ￭ Digite o CPF do cliente: ");
                        CPF = input.nextLine();

                        for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {

                            if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)) {
                                ContaCorrente corrente = new ContaCorrente(DadosDoBanco.UsuarioCliente.get(i));
                                System.out.println("\n   \uD83D\uDDF8 CONTA CORRENTE ADICIONADA COM SUCESSO !!!");
                                corrente.toString();
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()) {
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta poupança!"); // NÃO ESTÁ FUNCIONANDO
                    } else {
                        System.out.print("\n ￭ Digite o CPF do cliente: ");
                        CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                            if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)) {
                                ContaPoupanca poupanca = new ContaPoupanca(DadosDoBanco.UsuarioCliente.get(i));
                                System.out.println("\n   \uD83D\uDDF8 CONTA POUPANÇA ADICIONADA COM SUCESSO !!!");
                                poupanca.toString();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("\n\ud83d\uddd9 Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    protected static void listar() {
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;

        while (exibirAdicionar) {

            System.out.println("\n\uD83D\uDFB4 MENU - LISTAR CLIENTES | CONTAS");
            System.out.println(" [1] Listar Clientes");
            System.out.println(" [2] Listar Contas Correntes");
            System.out.println(" [3] Listar Contas Poupanças");
            System.out.println(" [4] Sair");
            System.out.print("\uD83D\uDF82 Selecione a opção desejada: ");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()) {
                        System.out.println("\n\ud83d\uddd9 Não existe clientes cadastrados!");
                    } else {
                        System.out.println(DadosDoBanco.ListarUsuarioCliente());
                    }
                    break;
                case 2:
                    if (DadosDoBanco.ListarContaCorrente().isEmpty()) {
                        System.out.println("\n\ud83d\uddd9 Não existe nenhuma conta corrente cadastrada!");
                    } else {
                        System.out.println(DadosDoBanco.ListarContaCorrente());
                    }
                    break;
                case 3:
                    if (DadosDoBanco.ListarContaPoupanca().isEmpty()) {
                        System.out.println("\n\ud83d\uddd9 Não existe nenhuma conta poupança cadastrada!");
                    } else {
                        System.out.println(DadosDoBanco.ListarContaPoupanca());
                    }
                    break;
                case 4:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("\n\ud83d\uddd9 Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    protected static void removerContas() {
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;

        while (exibirAdicionar) {

            System.out.println("\n\uD83D\uDFB4 MENU - REMOVER CONTAS");
            System.out.println(" [1] Remover Conta Corrente");
            System.out.println(" [2] Remover Conta Poupança");
            System.out.println(" [3] Sair");
            System.out.print("\uD83D\uDF82 Selecione a opção desejada: ");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    if (DadosDoBanco.ListarContaCorrente().isEmpty()) {
                        System.out.println("\n\ud83d\uddd9 Não existe nenhuma conta corrente cadastrada!");
                    } else {
                        System.out.print("\n ￭ Digite o CPF do cliente que deseja remover a conta corrente: ");
                        String CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                            if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                String corrente = DadosDoBanco.ContaCorrente.get(i).toString();
                                DadosDoBanco.ContaCorrente.remove(i);
                                System.out.println("\n   \uD83D\uDDF8 CONTA REMOVIDA COM SUCESSO: " + corrente);
                            }
                        }
                    }
                    break;
                case 2:
                    if (DadosDoBanco.ListarContaPoupanca().isEmpty()) {
                        System.out.println("\n\ud83d\uddd9 Não existe nenhuma conta poupança cadastrada!");
                    } else {
                        System.out.print("\n ￭ Digite o CPF do cliente que deseja remover a conta poupança!");
                        String CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                            if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                String corrente = DadosDoBanco.ContaPoupanca.get(i).toString();
                                DadosDoBanco.ContaPoupanca.remove(i);
                                System.out.println("\n   \uD83D\uDDF8 CONTA REMOVIDA COM SUCESSO: " + corrente);
                            }
                        }
                    }
                    break;
                case 3:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("\n\ud83d\uddd9 Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    protected static void editarUsuario() {
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;
        String CPF = null;
        String nome = null;
        String email = null;
        UsuarioCliente cliente = null;

        while (exibirAdicionar) {

            System.out.println("\n\uD83D\uDFB4 MENU - EDITAR CLIENTES");
            System.out.println(" [1] Para editar o nome");
            System.out.println(" [2] Para editar o email");
            System.out.println(" [3] Sair");
            System.out.print("\uD83D\uDF82 Selecione a opção desejada: ");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Informe o CPF do cliente que deseja editar o nome!");
                    CPF = input.nextLine();
                    for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                        if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)) {
                            System.out.println("Informe o novo nome que deseja cadastrar!");
                            nome = input.nextLine();
                            DadosDoBanco.UsuarioCliente.get(i).setNome(nome);
                        }
                    }
                    if (nome != null) {
                        for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                            if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).setNome(nome);
                            }
                        }
                        for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                            if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).setNome(nome);
                            }
                        }
                        System.out.println("Nome alterado com sucesso para o CPF " + CPF);
                    } else {
                        System.out.println("Não encontramos o cadastro para o CPF " + CPF);
                    }
                    break;
                case 2:
                    System.out.println("Informe o CPF do cliente que deseja editar o email!");
                    CPF = input.nextLine();
                    for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                        if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)) {
                            System.out.println("Informe o novo email que deseja cadastrar!");
                            email = input.nextLine();
                            DadosDoBanco.UsuarioCliente.get(i).setEmail(email);
                        }
                    }
                    if (email != null) {
                        for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                            if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).setEmail(email);
                            }
                        }
                        for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                            if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).setEmail(email);
                            }
                        }
                        System.out.println("Email alterado com sucesso para o CPF " + CPF);
                    } else {
                        System.out.println("Não encontramos o cadastro para o CPF " + CPF);
                    }
                    break;
                case 3:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("\n\ud83d\uddd9 Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    protected static void movimentarConta() {
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;
        String CPF = null;
        String nome = null;
        String email = null;
        UsuarioCliente cliente = null;
        BigDecimal valor = BigDecimal.ZERO;
        Conta destino = null;

        while (exibirAdicionar) {

            System.out.println("\n\uD83D\uDFB4 MENU - MOVIMENTAR CONTA");
            System.out.println(" [1] Depósito");
            System.out.println(" [2] Retirada");
            System.out.println(" [3] Transferência");
            System.out.println(" [4] Sair");
            System.out.print("\uD83D\uDF82 Selecione a opção desejada: ");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("\n ￭ Digite o CPF vinculado a conta que deseja depositar: ");
                    CPF = input.nextLine();
                    for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                        if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("Conta corrente encontrada!");
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                            System.out.print("\n ￭ Digite o valor que deseja depositar: ");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaCorrente.get(i).depositar(valor);
                            System.out.println("\nO valor " + valor + " foi depositado com sucesso!");
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                            break;
                        }
                    }
                    for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                        if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("Conta poupança encontrada!");
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                            System.out.print("\n ￭ Digite o valor que deseja depositar: ");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaPoupanca.get(i).depositar(valor);
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("\n ￭ Digite o CPF vinculado a conta que deseja sacar: ");
                    CPF = input.nextLine();
                    for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                        if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("\nConta corrente encontrada!");
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                            System.out.print("\n ￭ Digite o valor que deseja sacar: ");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaCorrente.get(i).retirar(valor);
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                            break;
                        }
                    }
                    for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                        if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("\nConta poupança encontrada!");
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                            System.out.print("\n ￭ Digite o valor que deseja sacar: ");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaPoupanca.get(i).retirar(valor);
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n ￭ Digite o CPF vinculado a conta que irá receber o dinheiro (conta destino): ");
                    CPF = input.nextLine();
                    for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                        if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("\nConta corrente destino encontrada!");
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                            destino = DadosDoBanco.ContaCorrente.get(i);
                        }
                    }
                    for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                        if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("\nConta poupança destino encontrada!");
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                            destino = DadosDoBanco.ContaPoupanca.get(i);
                        }
                    }
                    System.out.println("\n ￭ Digite o CPF vinculado a conta que irá enviar o dinheiro (conta origem): ");
                    CPF = input.nextLine();
                    for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                        if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("\nConta corrente origem encontrada!");
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                            System.out.print("\nDigite o valor que deseja transferir: ");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaCorrente.get(i).tranferir(valor, destino);
                            System.out.println("\nConta corrente origem: " + DadosDoBanco.ContaCorrente.get(i));
                            break;
                        }
                    }
                    for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                        if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("Conta poupança origem encontrada: ");
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                            System.out.print("\nDigite o valor que deseja sacar: ");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaPoupanca.get(i).tranferir(valor, destino);
                            System.out.println("Conta corrente origem: " + DadosDoBanco.ContaPoupanca.get(i));
                            break;
                        }
                    }
                    break;
                case 4:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("\n\ud83d\uddd9 Opção inválida, tente novamente!");
                    break;
            }
        }
    }
}