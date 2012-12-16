package br.ufpb.sistemadeagenda;

import java.util.*;
import java.io.*;

/**
 * Classe para controle de contatos de uma agenda.
 * 
 * @author Marcelo Fernandes.
 *
 */
public class Agenda implements AgendaIF{

	private List<Contato> contatos;
	private GravadorDeContatosList gravador;

	/**
	 * Construtor padrão que inicializa as variáveis.
	 * 
	 */
	public Agenda(){
		gravador = new GravadorDeContatosList();
		carregaContatos();
	}

	/**
	 * Método para gravar os contatos no arquivo.
	 * 
	 */
	private void gravaContatos(){
		try{
			gravador.gravaContato(contatos);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		
		
	}
	
	/**
	 * Método para carregar os contator do arquivo.
	 * 
	 */
	private void carregaContatos(){
		try{
			contatos = gravador.leContato();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			this.contatos = new ArrayList<Contato>();
		}
	}

	/**
	 * Método para adicionar um contato.
	 * 
	 * @param nome O nome do contato a ser adicionado.
	 * 
	 * @param tel O telefone do contato a ser adicionado.
	 * 
	 */
	public void adicionarContato(String nome, String tel){
		for(Contato c: this.contatos){
			if(c.getNome().equals(nome)){
				c.setTelefone(tel);
				gravaContatos();
				return;
			}
		}
		this.contatos.add( new Contato(nome,tel) );
		gravaContatos();
		System.out.println("Contato "  + nome + " adicionado.");
	}
	
	/**
	 * Método para remover um contato.
	 * 
	 * @param nomeContato O nome do contato a ser removido.
	 * 
	 * @throws ContatoInexistenteException exceção que será lançada caso o contato não exista.
	 */
	public void removerContato(String nomeContato)throws ContatoInexistenteException{
		for(Contato c: this.contatos){
			if( c.getNome().equals(nomeContato) ){
				this.contatos.remove(c);
				gravaContatos();
				return;
			}
		}
		throw new ContatoInexistenteException("Contato " + nomeContato + " nao encontrado.");
	}
	
	/**
	 * Método para pesquisar um contato.
	 * 
	 * @param nomeContato O nome do contato a ser pesquisado.
	 * 
	 * @throws ContatoInexistenteException exceção que será lançada caso o contato não exista.
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
	
	/**
	 * Método que pega todos os contatos.
	 * 
	 * @return Retorna uma coleção con todos os contatos.
	 * 
	 */
	public Collection<Contato> getContatos(){
		Collection<Contato> c = new ArrayList<Contato>();
		c.addAll(this.contatos);
		return c;
	}

	/**
	 * Método que pega todos os contatos, só que ordenados.
	 * 
	 * @return Retorna um iterator com todos os contatos ordenados.
	 * 
	 */
	public Iterator<Contato> getContatosOrdenados(){
		List<Contato> lista = new ArrayList<Contato>();
		lista.addAll(this.contatos);
		Collections.sort(lista);
		return lista.iterator();
	}
}
