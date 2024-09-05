import java.util.ArrayList;
import java.util.List;

public class DadosDoBanco {
    static List<ContaCorrente> ContaCorrente = new ArrayList<>();
    static List<ContaPoupanca> ContaPoupanca = new ArrayList<>();
    static List<UsuarioCliente> UsuarioCliente = new ArrayList<>();

    public static List<ContaCorrente> ListarContaCorrente(){
        return ContaCorrente;
    }

    public static List<ContaPoupanca> ListarContaPoupanca(){
        return ContaPoupanca;
    }

    public static List<UsuarioCliente> ListarUsuarioCliente(){
        return UsuarioCliente;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
