import java.util.Scanner;

public class UsuarioCliente extends Usuario{

    static String clienteNome;
    static String clienteEmail;
    static String clienteCPF;

    private UsuarioCliente() {
        super(clienteNome, clienteEmail, clienteCPF);
        DadosDoBanco.UsuarioCliente.add(this);
    }

    private UsuarioCliente(String CPF) {
        super(clienteNome, clienteEmail, clienteCPF);
        DadosDoBanco.UsuarioCliente.add(this);
    }

    public static UsuarioCliente adicionarCliente(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        clienteNome = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        clienteEmail = scanner.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        clienteCPF = scanner.nextLine();

        return new UsuarioCliente();
    }

    public static UsuarioCliente adicionarCliente(String CPF){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        clienteNome = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        clienteEmail = scanner.nextLine();
        clienteCPF = CPF;

        return new UsuarioCliente(clienteCPF);
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "nome ='" + getNome() + '\'' +
                ", email ='" + getEmail() + '\'' +
                ", CPF ='" + getCPF() + '\'' +
                '}';
    }


}
