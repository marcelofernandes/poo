package br.ufpb.sistemadeagenda;

public class ProgramaExercicio5{
	public static void main(String [] args){
		Agenda agenda = new Agenda();
		agenda.adicionarContato("Marcelo","12345645");
		try{
			Contato c = agenda.pesquisarContato("Marcelo");
			System.out.println("Contato " + c.getNome() + " encontrado.");
		}
		catch(ContatoInexistenteException e){
			System.err.println(e.getMessage());
		}
		try{
			Contato c = agenda.pesquisarContato("Maria");
			System.out.println("Contato " + c.getNome() + " encontrado.");
		}
		catch(ContatoInexistenteException e){
			System.err.println(e.getMessage());
		}
	}
}
	