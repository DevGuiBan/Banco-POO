import java.util.Scanner;

public class Agenda {

    Scanner sc = new Scanner(System.in);

    Contato[] contatosDaAgenda =  new Contato[1];

    public void captarContatoParaAgenda(){

        String numeroContato;
        String telefoneContato;
        String emailContato;

        System.out.println("Digite o nome do contato: ");
        numeroContato = sc.nextLine();
        System.out.println("Digite o nome do telefone: ");
        telefoneContato = sc.nextLine();
        System.out.println("Digite o nome do email: ");
        emailContato = sc.nextLine();

        Contato contatoCriadoParaAgenda = new Contato(numeroContato, telefoneContato, emailContato);
        adicionarContatoNaAgenda(contatoCriadoParaAgenda);
    }


    public void adicionarContatoNaAgenda(Contato contato){
        for (int i = 0; i < contatosDaAgenda.length; i++) {
            if(contatosDaAgenda[i] == null){
                contatosDaAgenda[i] = contato;
            }
        }
        aumentarONumeroDeContatosDaAgenda();
    }

    public void aumentarONumeroDeContatosDaAgenda(){
        Contato[] contatosDaAgendaAumentado =  new Contato[contatosDaAgenda.length + 1];
        for (int i = 0; i < contatosDaAgenda.length; i++) {
            contatosDaAgendaAumentado[i] = contatosDaAgenda[i];
        }
        contatosDaAgenda = contatosDaAgendaAumentado;
    }

    //testando o git
    //testando o git2
    //testando o git3

}