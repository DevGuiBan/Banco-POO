
public class Main {
    public static void main(String[] args) {
        //Menu menu = new Menu();
        //menu.exibirMenu();

        UsuarioCliente cliente = new UsuarioCliente("Gustavo", "gushabib@gmail.com", "21988668348");

        ContaCorrente conta = new ContaCorrente(cliente);
        System.out.println("+++++++++corrente+++++++++++");

        System.out.println(conta);

        ContaPoupanca poupanca = new ContaPoupanca(cliente);
        System.out.println("+++++++++poupança+++++++++++");

        System.out.println(poupanca);
    }
}