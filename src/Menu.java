import java.util.Scanner;

public class Menu {

    Agenda agenda = new Agenda();
    Scanner sc = new Scanner(System.in);

    public void exibirMenu() {

        while (true) {

            System.out.println("    [1] Adicionar Contato");
            System.out.println("    [2] Detalhar Contato");
            System.out.println("    [3] Editar Contato");
            System.out.println("    [4] Remover Contato");
            System.out.println("    [5] Listar Contatos");
            System.out.println("    [6] Sair");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    agenda.captarContatoParaAgenda();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        }
    }
}
