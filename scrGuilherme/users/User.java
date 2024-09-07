package scrGuilherme.users;

public class User {

    public enum Accesslevel {
        ADMIN, USER
    }

    private String nome;
    private String cpf;
    private int idade;
    private String email;
    private String contato;
    private Accesslevel accesslevel;

    public User(String nome, String cpf, int idade, String email, String contato, Accesslevel accesslevel) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.contato = contato;
        this.accesslevel = accesslevel;
    }

    //get's

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getContato() {
        return contato;
    }

    public Accesslevel getAccessLevel() {
        return accesslevel;
    }

    //set's

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setAccessLevel(Accesslevel accesslevel) {
        this.accesslevel = accesslevel;
    }
}
