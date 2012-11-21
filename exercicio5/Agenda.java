package br.ufpb.sistemadeagenda;

import java.util.*;

/**
 * Classe para controle de contatos de uma agenda.
 * 
 * @author Marcelo Fernandes.
 *
 */
public class Agenda implements AgendaIF{

	private List<Contato> contatos;
	
	/**
	 * Construtor padrão que inicializa o ArrayList.
	 * 
	 */
	public Agenda(){
		this.contatos = new ArrayList<Contato>();
	}

	public void adicionarContato(String nome, String tel){
		this.contatos.add( new Contato(nome,tel) );
		System.out.println("Contato "  + nome + " adicionado.");
	}
	public void removerContato(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contatos){
			if( c.getNome().equals(nomeContato) ){
				this.contatos.remove(c);
				return;
			}
		}
		throw new ContatoInexistenteException("Contato " + nomeContato + " nao encontrado.");
	}
	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contatos){
			if( c.getNome().equals(nomeContato) ){
				return c;
			}
		}
		throw new ContatoInexistenteException("Contato " + nomeContato +" nao cadastrado.");
	}
}