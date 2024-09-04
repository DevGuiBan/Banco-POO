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
            System.out.println("    [3] Editar Usuario");
            System.out.println("    [4] Remover Usuario | Conta");
            System.out.println("    [5] Sair");
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
                    exibirMenu = false;
                    break;


            }

        }
    }

    private static void adicionar(){

        Scanner input = new Scanner(System.in);

        boolean exibirAdicionar = true;

        UsuarioCliente cliente = null;
        UsuarioGerente gerente = null;

        while (exibirAdicionar) {

            System.out.println(" MENU PARA ADICIONAR USUARIO E CONTA");
            System.out.println("    [1] Adicionar Cliente");
            System.out.println("    [2] Adicionar Gerente");
            System.out.println("    [3] Adicionar Conta Corrente");
            System.out.println("    [4] Adicionar Conta Poupança");
            System.out.println("    [5] Sair");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    cliente = UsuarioCliente.adicionarCliente();
                    System.out.println("Cliente adicionado com sucesso!");
                    System.out.println(cliente);
                    break;
                case 2:
                    gerente = UsuarioGerente.adicionarGerente();
                    System.out.println("Gerente adicionado com sucesso!");
                    System.out.println(gerente);
                    break;
                case 3:
                    if (cliente == null){
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta corrente!");
                    }else{
                        ContaCorrente corrente = new ContaCorrente(cliente);
                        System.out.println("Conta corrente adicionada com sucesso!");
                        System.out.println(corrente);
                    }
                    break;
                case 4:
                    if (gerente == null){
                        System.out.println("Cliente ainda não criado, criar antes de adicionar uma conta poupança!");
                    }else{
                        ContaPoupanca poupanca = new ContaPoupanca(cliente);
                        System.out.println("Conta poupança adicionada com sucesso!");
                        System.out.println(poupanca);
                    }
                    break;
                case 5:
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
            System.out.println("    [2] Listar Gerentes");
            System.out.println("    [3] Listar Contas Correntes");
            System.out.println("    [4] Listar Contas Poupanças");
            System.out.println("    [5] Sair");
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
                    if (DadosDoBanco.ListarUsuarioGerente().isEmpty()){
                        System.out.println("Não existe gerentes cadastrados!");
                    }else{
                        System.out.println(DadosDoBanco.ListarUsuarioGerente());
                    }
                    break;
                case 3:
                    if (DadosDoBanco.ListarContaCorrente().isEmpty()){
                        System.out.println("Não existe nenhuma conta corrente cadastrada!");
                    }else{
                        System.out.println(DadosDoBanco.ListarContaCorrente());
                    }
                    break;
                case 4:
                    if (DadosDoBanco.ListarContaPoupanca().isEmpty()){
                        System.out.println("Não existe nenhuma conta poupança cadastrada!");
                    }else{
                        System.out.println(DadosDoBanco.ListarContaPoupanca());
                    }
                    break;
                case 5:
                    exibirAdicionar = false;
                    break;
            }
        }
    }
}
