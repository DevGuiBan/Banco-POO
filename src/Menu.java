import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public static void exibirMenu() {
        Scanner input = new Scanner(System.in);

        boolean exibirMenu = true;

        while (exibirMenu) {
            System.out.println("\n\uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4 MENU GERAL \uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4\uD83D\uDFB4");
            System.out.println(" [1] Adicionar Clientes | Conta");
            System.out.println(" [2] Listar Clientes | Contas");
            System.out.println(" [3] Movimentar Conta");
            System.out.println(" [4] Editar Cliente");
            System.out.println(" [5] Remover Contas");
            System.out.println(" [6] Sair");
            System.out.print("\uD83D\uDF82 Selecione a opção desejada: ");
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
                    MetodosMenu.movimentarConta();
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
                    System.out.println("\n\ud83d\uddd9 Opção inválida, tente novamente!");
                    break;
            }

        }
    }
}