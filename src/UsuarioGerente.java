import java.util.Scanner;

public class UsuarioGerente extends Usuario{

    static String clienteNome;
    static String clienteEmail;
    static String clienteTelefone;

    private UsuarioGerente() {
        super(clienteNome, clienteEmail, clienteTelefone);
        DadosDoBanco.UsuarioGerente.add(this);
    }

    public static UsuarioGerente adicionarGerente(){

        String[] adicionado = new String[3];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do gerente: ");
        adicionado[0] = scanner.nextLine();
        System.out.println("Digite o email do gerente: ");
        adicionado[1] = scanner.nextLine();
        System.out.println("Digite o telefone do gerente: ");
        adicionado[2] = scanner.nextLine();

        clienteNome = adicionado[0];
        clienteEmail = adicionado[1];
        clienteTelefone = adicionado[2];

        return new UsuarioGerente();
    }

    @Override
    public String toString() {
        return "Gerente {" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                '}';
    }
}
