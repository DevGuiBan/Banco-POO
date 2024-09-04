import java.util.Scanner;

public class UsuarioCliente extends Usuario{

    static String clienteNome;
    static String clienteEmail;
    static String clienteTelefone;

    private UsuarioCliente() {
        super(clienteNome, clienteEmail, clienteTelefone);
        DadosDoBanco.UsuarioCliente.add(this);
    }

    public static UsuarioCliente adicionarCliente(){

        String[] adicionado = new String[3];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        adicionado[0] = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        adicionado[1] = scanner.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        adicionado[2] = scanner.nextLine();

        clienteNome = adicionado[0];
        clienteEmail = adicionado[1];
        clienteTelefone = adicionado[2];

        return new UsuarioCliente();
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                '}';
    }


}
