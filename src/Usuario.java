public abstract class Usuario {
    private String nome;
    private String email;
    private String CPF;

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.CPF = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String telefone) {
        this.CPF = telefone;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", CPF='" + CPF + '\'' +
                '}';
    }
}
