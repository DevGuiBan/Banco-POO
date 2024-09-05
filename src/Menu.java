import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    public static void exibirMenu() {

        Scanner input = new Scanner(System.in);

        boolean exibirMenu = true;

        while (exibirMenu) {

            System.out.println("----------- MENU GERAL -----------");
            System.out.println("    [1] Adicionar Cliente | Conta");
            System.out.println("    [2] Listar Clientes | Contas");
            System.out.println("    [3] Movimentar Conta");
            System.out.println("    [4] Editar Cliente");
            System.out.println("    [5] Remover Contas");
            System.out.println("    [6] Sair");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    MetodosMenu.adicionar();
                    break;
                case 2:
                    MetodosMenu.listar();
                    break;
                case 3:
                    break;
                case 4:
                    MetodosMenu.editarUsuario();
                    break;
                case 5:
                    MetodosMenu.removerContas();
                    break;
                case 6:
                    exibirMenu = false;
                    break;
                default:
                    System.out.println("Opção digitada errada, tente novamente!");
                    break;
            }

        }
    }
}
