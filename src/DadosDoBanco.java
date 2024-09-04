import java.util.ArrayList;
import java.util.List;

public class DadosDoBanco {
    static List<ContaCorrente> ContaCorrente = new ArrayList<>();
    static List<ContaPoupanca> ContaPoupanca = new ArrayList<>();
    static List<UsuarioCliente> UsuarioCliente = new ArrayList<>();
    static List<UsuarioGerente> UsuarioGerente = new ArrayList<>();

    public static List<ContaCorrente> ListarContaCorrente(){
        return ContaCorrente;
    }

    public static List<ContaPoupanca> ListarContaPoupanca(){
        return ContaPoupanca;
    }

    public static List<UsuarioCliente> ListarUsuarioCliente(){
        return UsuarioCliente;
    }

    public static List<UsuarioGerente> ListarUsuarioGerente(){
        return UsuarioGerente;
    }
}
