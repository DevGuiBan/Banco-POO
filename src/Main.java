
public class Main {
    public static void main(String[] args) {

        UsuarioCliente usuario1 = UsuarioCliente.adicionarUsuario();

        System.out.println(usuario1);

        UsuarioGerente gerente1 = UsuarioGerente.adicionarGerente();

        System.out.println(gerente1);

    }
}