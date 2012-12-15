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

	/**
	 * Método para adicionar um contato.
	 * 
	 * @param nome O nome do contato a ser adicionado.
	 * 
	 * @param tel O telefone do contato a ser sdicionado.
	 * 
	 */
	public void adicionarContato(String nome, String tel){
		this.contatos.add( new Contato(nome,tel) );
		System.out.println("Contato "  + nome + " adicionado.");
	}
	
	/**
	 * Método para remover um contato.
	 * 
	 * @param nomeContato O nome do contato a ser removido.
	 * 
	 * @throws ContatoInexixtenteException Exceção lançada caso não exista o contato.
	 * 
	 */
	public void removerContato(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contatos){
			if( c.getNome().equals(nomeContato) ){
				this.contatos.remove(c);
				return;
			}
		}
		throw new ContatoInexistenteException("Contato " + nomeContato + " nao encontrado.");
	}
	
	/** Método para pesquisar um contato.
	 * 
	 * @param nomeContato O nome do contato a ser pesquisado.
	 * 
	 * @return Retorna o contato pesquisado.
	 * 
	 * @throws ContatoInexistenteException Exceção lançada caso não exista o contato.
	 * 
	 */
	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contatos){
			if( c.getNome().equals(nomeContato) ){
				return c;
			}
		}
		throw new ContatoInexistenteException("Contato " + nomeContato +" nao cadastrado.");
	}
}
