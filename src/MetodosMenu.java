import java.math.BigDecimal;
import java.util.Scanner;

public class MetodosMenu {

    protected static void adicionar(){

        Scanner input = new Scanner(System.in);

        boolean exibirAdicionar = true;

        UsuarioCliente cliente = null;

        while (exibirAdicionar) {

            System.out.println(" MENU PARA ADICIONAR USUARIO E CONTA");
            System.out.println("    [1] Adicionar Cliente");
            System.out.println("    [2] Adicionar Conta Corrente");
            System.out.println("    [3] Adicionar Conta Poupança");
            System.out.println("    [4] Sair");
            int escolha = input.nextInt();
            input.nextLine();

            String CPF = null;

            switch (escolha) {
                case 1:
                    if(DadosDoBanco.UsuarioCliente.isEmpty()){
                        cliente = UsuarioCliente.adicionarCliente();
                        System.out.println("Cliente adicionado com sucesso!");
                        System.out.println(cliente);
                        break;
                    }else {
                        System.out.println("Informe o CPF do cliente que deseja cadastrar!");
                        CPF = input.nextLine();
                        boolean fim = true;
                            for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                                if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)) {
                                    System.out.println("O CPF informado já tem cadastro!");
                                    fim = false;
                                    break;
                                }
                            }
                            if (fim) {
                                cliente = UsuarioCliente.adicionarCliente(CPF);
                                System.out.println("Cliente adicionado com sucesso!");
                                System.out.println(cliente);
                                break;
                            }
                     }
                    break;
                case 2:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()){
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta corrente!");
                        break;
                    }else{
                        System.out.println("Informe o CPF do cliente que deseja cadastrar a conta corrente!");
                        CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                            if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)){
                                ContaCorrente corrente = new ContaCorrente(DadosDoBanco.UsuarioCliente.get(i));
                                System.out.println("Conta corrente adicionada com sucesso!");
                                System.out.println(corrente);
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()){
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta poupança!");
                    }else{
                        System.out.println("Informe o CPF do cliente que deseja cadastrar a conta poupança!");
                        CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                            if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)){
                                ContaPoupanca poupanca = new ContaPoupanca(DadosDoBanco.UsuarioCliente.get(i));
                                System.out.println("Conta poupança adicionada com sucesso!");
                                System.out.println(poupanca);
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("Opção digitada errada, tente novamente!");
                    break;
            }
        }
    }

    protected static void listar(){
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;

        while (exibirAdicionar) {

            System.out.println(" MENU PARA LISTAR USUARIO E CONTA");
            System.out.println("    [1] Listar Clientes");
            System.out.println("    [2] Listar Contas Correntes");
            System.out.println("    [3] Listar Contas Poupanças");
            System.out.println("    [4] Sair");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()){
                        System.out.println("Não existe clientes cadastrados!");
                    }else{
                        System.out.println(DadosDoBanco.ListarUsuarioCliente());
                    }
                    break;
                case 2:
                    if (DadosDoBanco.ListarContaCorrente().isEmpty()){
                        System.out.println("Não existe nenhuma conta corrente cadastrada!");
                    }else{
                        System.out.println(DadosDoBanco.ListarContaCorrente());
                    }
                    break;
                case 3:
                    if (DadosDoBanco.ListarContaPoupanca().isEmpty()){
                        System.out.println("Não existe nenhuma conta poupança cadastrada!");
                    }else{
                        System.out.println(DadosDoBanco.ListarContaPoupanca());
                    }
                    break;
                case 4:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("Opção digitada errada, tente novamente!");
                    break;
            }
        }
    }

    protected static void removerContas(){
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;

        while (exibirAdicionar) {

            System.out.println(" MENU PARA REMOVER CONTAS");
            System.out.println("    [1] Remover Conta Corrente");
            System.out.println("    [2] Remover Conta Poupança");
            System.out.println("    [3] Sair");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    if (DadosDoBanco.ListarContaCorrente().isEmpty()){
                        System.out.println("Não existe nenhuma conta corrente cadastrada!");
                    }else{
                        System.out.println("Informe o CPF do cliente que deseja remover a conta corrente!");
                        String CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                            if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)){
                                String corrente = DadosDoBanco.ContaCorrente.get(i).toString();
                                DadosDoBanco.ContaCorrente.remove(i);
                                System.out.println("Conta removida com sucesso: " + corrente);
                            }
                        }
                    }
                    break;
                case 2:
                    if (DadosDoBanco.ListarContaPoupanca().isEmpty()){
                        System.out.println("Não existe nenhuma conta poupança cadastrada!");
                    }else {
                        System.out.println("Informe o CPF do cliente que deseja remover a conta poupança!");
                        String CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                            if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)){
                                String corrente = DadosDoBanco.ContaPoupanca.get(i).toString();
                                DadosDoBanco.ContaPoupanca.remove(i);
                                System.out.println("Conta removida com sucesso: " + corrente);
                            }
                        }
                    }
                    break;
                case 3:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("Opção digitada errada, tente novamente!");
                    break;
            }
        }
    }

    protected static void editarUsuario(){
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;
        String CPF = null;
        String nome = null;
        String email = null;
        UsuarioCliente cliente = null;

        while (exibirAdicionar) {

            System.out.println(" MENU PARA EDITAR CLIENTE");
            System.out.println("    [1] Para editar o nome");
            System.out.println("    [2] Para editar o email");
            System.out.println("    [3] Sair");
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
                    if (nome != null){
                        for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++){
                            if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).setNome(nome);
                            }
                        }
                        for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++){
                            if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).setNome(nome);
                            }
                        }
                        System.out.println("Nome alterado com sucesso para o CPF " + CPF);
                    }else{
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
                    if (email != null){
                        for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++){
                            if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).setEmail(email);
                            }
                        }
                        for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++){
                            if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).setEmail(email);
                            }
                        }
                        System.out.println("Email alterado com sucesso para o CPF " + CPF);
                    }else{
                        System.out.println("Não encontramos o cadastro para o CPF " + CPF);
                    }
                    break;
                case 3:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("Opção digitada errada, tente novamente!");
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

        while (exibirAdicionar) {

            System.out.println(" MENU PARA MOVIMENTO DE CONTA");
            System.out.println("    [1] Depósito");
            System.out.println("    [2] Retirada");
            System.out.println("    [3] Transferência");
            System.out.println("    [4] Sair");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Informe o CPF vinculado a conta que deseja depositar.");
                    CPF = input.nextLine();
                    for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++) {
                        if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("Conta corrente encontrada: ");
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                            System.out.println("Informe o valor que deseja depositar depositar.");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaCorrente.get(i).depositar(valor);
                            System.out.println("O valor " + valor + " foi depositado com sucesso!");
                            System.out.println(DadosDoBanco.ContaCorrente.get(i));
                        }
                        break;
                    }
                    for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++) {
                        if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                            System.out.println("Conta poupança encontrada: ");
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                            System.out.println("Informe o valor que deseja depositar depositar.");
                            valor = input.nextBigDecimal();
                            DadosDoBanco.ContaPoupanca.get(i).depositar(valor);
                            System.out.println("O valor " + valor + " foi depositado com sucesso!");
                            System.out.println(DadosDoBanco.ContaPoupanca.get(i));
                        }
                        break;
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
                    if (email != null){
                        for (int i = 0; i < DadosDoBanco.ListarContaCorrente().size(); i++){
                            if (DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaCorrente.get(i).usuarioCliente.get(0).setEmail(email);
                            }
                        }
                        for (int i = 0; i < DadosDoBanco.ListarContaPoupanca().size(); i++){
                            if (DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).getCPF().equals(CPF)) {
                                DadosDoBanco.ContaPoupanca.get(i).usuarioCliente.get(0).setEmail(email);
                            }
                        }
                        System.out.println("Email alterado com sucesso para o CPF " + CPF);
                    }else{
                        System.out.println("Não encontramos o cadastro para o CPF " + CPF);
                    }
                    break;
                case 3:
                    exibirAdicionar = false;
                    break;
                default:
                    System.out.println("Opção digitada errada, tente novamente!");
                    break;
            }
        }
    }
}
