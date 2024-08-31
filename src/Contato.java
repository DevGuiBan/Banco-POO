public class Contato {

    Agenda agenda = new Agenda();

    //Atributos
    private int id;
    private String nomeDoContato;
    private String numeroDeTelefoneDoContato;
    private String emailDoContato;

    //Construtores
    public Contato(String nomeDoContato, String numeroDeTelefoneDoContato, String emailDoContato) {
        this.nomeDoContato = nomeDoContato;
        this.numeroDeTelefoneDoContato = numeroDeTelefoneDoContato;
        this.emailDoContato = emailDoContato;
        this.id = agenda.contatosDaAgenda.length;
    }

    //Geters e Seters
    public String getEmailDoContato() {
        return emailDoContato;
    }
    public void setEmailDoContato(String emailDoContato) {
        this.emailDoContato = emailDoContato;
    }

    public String getNomeDoContato() {
        return nomeDoContato;
    }
    public void setNomeDoContato(String nomeContato) {
        this.nomeDoContato = nomeContato;
    }

    public String getNumeroDeTelefoneDoContato() {
        return numeroDeTelefoneDoContato;
    }
    public void setNumeroDeTelefoneDoContato(String numeroDeTelefoneDoContato) {
        this.numeroDeTelefoneDoContato = numeroDeTelefoneDoContato;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
