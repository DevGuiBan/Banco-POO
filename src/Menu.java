import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    public static void exibirMenu() {

        Scanner input = new Scanner(System.in);

        boolean exibirMenu = true;

        while (exibirMenu) {

            System.out.println("----------- MENU GERAL -----------");
            System.out.println("    [1] Adicionar Usuario | Conta");
            System.out.println("    [2] Listar Usuarios | Contas");
            System.out.println("    [3] Movimentar Conta");
            System.out.println("    [4] Editar Usuario");
            System.out.println("    [5] Remover Usuario | Conta");
            System.out.println("    [6] Sair");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exibirMenu = false;
                    break;
            }

        }
    }

    private static void adicionar(){

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

            switch (escolha) {
                case 1:
                    cliente = UsuarioCliente.adicionarCliente();
                    System.out.println("Cliente adicionado com sucesso!");
                    System.out.println(cliente);
                    break;
                case 2:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()){
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta corrente!");
                    }else{
                        System.out.println("Informe o CPF do cliente que deseja cadastrar a conta corrente!");
                        String CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                            if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)){
                                ContaCorrente corrente = new ContaCorrente(DadosDoBanco.UsuarioCliente.get(i));
                                System.out.println("Conta corrente adicionada com sucesso!");
                                System.out.println(corrente);
                            }
                        }
                    }
                    break;
                case 3:
                    if (DadosDoBanco.ListarUsuarioCliente().isEmpty()){
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta poupança!");
                    }else{
                        System.out.println("Informe o CPF do cliente que deseja cadastrar a conta poupança!");
                        String CPF = input.nextLine();
                        for (int i = 0; i < DadosDoBanco.ListarUsuarioCliente().size(); i++) {
                            if (DadosDoBanco.UsuarioCliente.get(i).getCPF().equals(CPF)){
                                ContaPoupanca poupanca = new ContaPoupanca(DadosDoBanco.UsuarioCliente.get(i));
                                System.out.println("Conta poupança adicionada com sucesso!");
                                System.out.println(poupanca);
                            }
                        }
                    }
                    break;
                case 4:
                    exibirAdicionar = false;
                    break;
            }
        }
    }

    private static void listar(){
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
            }
        }
    }

    private static void removerUsuarioOuConta(){
        Scanner input = new Scanner(System.in);
        boolean exibirAdicionar = true;

        while (exibirAdicionar) {

            System.out.println(" MENU PARA REMOVER CLIENTE OU CONTA");
            System.out.println("    [1] Remover Usuario");
            System.out.println("    [2] Remover Conta Corrente");
            System.out.println("    [3] Remover Conta Poupança");
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
            }
        }
    }
}
