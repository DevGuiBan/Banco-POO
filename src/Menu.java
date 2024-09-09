import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static Banco banco = new Banco();

    public static void exibirMenu() {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║                                              ║");
                System.out.println("║         ██████╗  ██████╗  ██████╗            ║");
                System.out.println("║         ██╔══██╗██╔═══██╗██╔═══██            ║");
                System.out.println("║         ██████╔╝██║   ██║██║   ██║           ║");
                System.out.println("║         ██╔═══╝ ██║   ██║██║   ██║           ║");
                System.out.println("║         ██║     ╚██████╔╝╚██████╔╝           ║");
                System.out.println("║         ╚═╝      ╚═════╝  ╚═════╝            ║");
                System.out.println("║           BANK POO - VERSION 1.0             ║");
                System.out.println("║                                              ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║                MENU PRINCIPAL                ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Adicionar Conta                       ║");
                System.out.println("║  [2] ⇨ Listar Contas                         ║");
                System.out.println("║  [3] ⇨ Movimentar Conta                      ║");
                System.out.println("║  [4] ⇨ Editar Conta                          ║");
                System.out.println("║  [5] ⇨ Remover Contas                        ║");
                System.out.println("║  [6] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        exibirMenuAdicionarConta();
                        break;
                    case 2:
                        exibirMenuListar();
                        break;
                    case 3:
                        exibirMenuTipodeContaPraMovimentacao();
                        break;
                    case 4:
                        exibirMenuTipodeContaPraEdicao();
                        break;
                    case 5:
                        exibirMenuRemoverContas();
                        break;
                    case 6:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 6);
        input.close();
    }

    public static void exibirMenuAdicionarConta() {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║               ADICIONAR CONTA                ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Adicionar Conta Corrente              ║");
                System.out.println("║  [2] ⇨ Adicionar Conta Poupança              ║");
                System.out.println("║  [3] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        banco.captarContaParaOBanco("corrente");
                        break;
                    case 2:
                        banco.captarContaParaOBanco("poupanca");
                        break;
                    case 3:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 3);
    }

    public static void exibirMenuListar() {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║                 LISTAR CONTAS                ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Listar Todas as Contas                ║");
                System.out.println("║  [2] ⇨ Listar Conta Corrente                 ║");
                System.out.println("║  [3] ⇨ Listar Conta Poupança                 ║");
                System.out.println("║  [4] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        banco.exibirTodasAsConta();
                        break;
                    case 2:
                        banco.exibirContaCorrente();
                        break;
                    case 3:
                        banco.exibirContaPoupanca();
                        break;
                    case 4:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 4);
    }

    public static void exibirMenuRemoverContas() {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║                REMOVER CONTA                 ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Remover Conta Corrente                ║");
                System.out.println("║  [2] ⇨ Remover Conta Poupança                ║");
                System.out.println("║  [3] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        banco.removerConta("corrente");
                        break;
                    case 2:
                        banco.removerConta("poupanca");
                        break;
                    case 3:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 3);
    }

    public static void exibirMenuTipodeContaPraEdicao() {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║           TIPO DE CONTA PRA EDIÇÃO           ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Editar Conta Corrente                 ║");
                System.out.println("║  [2] ⇨ Editar Conta Poupança                 ║");
                System.out.println("║  [3] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        exibirMenuEditarConta("corrente");
                        break;
                    case 2:
                        exibirMenuEditarConta("poupanca");
                        break;
                    case 3:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 3);
    }

    public static void exibirMenuEditarConta(String tipoDeConta) {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║                 EDITAR CONTA                 ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Editar Nome                           ║");
                System.out.println("║  [2] ⇨ Editar Email                          ║");
                System.out.println("║  [3] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        banco.editarConta(tipoDeConta, "nome");
                        break;
                    case 2:
                        banco.editarConta(tipoDeConta, "email");
                        break;
                    case 3:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 3);
    }

    public static void exibirMenuTipodeContaPraMovimentacao() {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║          TIPO DE CONTA PRA MOVITAÇÃO         ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Conta Corrente                        ║");
                System.out.println("║  [2] ⇨ Conta Poupança                        ║");
                System.out.println("║  [3] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        exibirMenuMovimentarConta("corrente");
                        break;
                    case 2:
                        exibirMenuMovimentarConta("poupanca");
                        break;
                    case 3:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 3);
    }

    public static void exibirMenuMovimentarConta(String tipoDeConta) {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║               MOVIMENTAR CONTA               ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Depositar                             ║");
                System.out.println("║  [2] ⇨ Sacar                                 ║");
                System.out.println("║  [3] ⇨ Transferir                            ║");
                System.out.println("║  [4] ⇨ Sair                                  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                switch (escolha) {
                    case 1:
                        banco.realizarOperacao(tipoDeConta, "depositar");
                        break;
                    case 2:
                        banco.realizarOperacao(tipoDeConta, "sacar");
                        break;
                    case 3:
                        banco.realizarOperacao(tipoDeConta, "transferir");
                        break;
                    case 4:
                        break;
                    default:
                        throw new MenuException("Opção digitada errada, tente novamente!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 4);
    }

    public static String exibirMenuTipodeConta() {

        Scanner input = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║          TIPO DE CONTA PRA MOVITAÇÃO         ║");
                System.out.println("╠══════════════════════════════════════════════╣");
                System.out.println("║  [1] ⇨ Conta Corrente                        ║");
                System.out.println("║  [2] ⇨ Conta Poupança                        ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║         Selecione a tarefa desejada...       ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.print(">>> Input: ");

                escolha = input.nextInt();
                input.nextLine();

                return switch (escolha) {
                    case 1 -> "corrente";
                    case 2 -> "poupanca";
                    default -> throw new MenuException("Opção digitada errada, tente novamente!");
                };

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                input.nextLine();
            } catch (MenuException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (escolha != 3);
        return "";
    }

}
