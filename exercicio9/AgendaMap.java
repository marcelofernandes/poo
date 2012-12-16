package br.ufpb.sistemadeagenda;

import java.util.*;
import java.io.*;

/**
 * Classe para controle de contatos de uma agenda usando HashMap.
 * 
 * @author Marcelo Fernandes.
 *
 */
public class AgendaMap implements AgendaIF{

	private Map<String, Contato> contatos;
	private GravadorDeContatosMap gravador;

	/**
	 * Construtor padrão que inicializa as variáveis.
	 * 
	 */
	public AgendaMap(){
		gravador = new GravadorDeContatosMap();
		carregaContatos();
	}

	/**
	 * Método para gravar os contatos no arquivo.
	 * 
	 */
	private void gravaContatos(){
		try{
			gravador.gravaContatos(contatos);
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
			this.contatos = new HashMap<String, Contato>();
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
		this.contatos.put(nome, new Contato(nome,tel) );
		System.out.println("Contato "  + nome + " adicionado.");
		gravaContatos();
	}

	/**
	 * Método para remover um contato.
	 * 
	 * @param nomeContato O nome do contato a ser removido.
	 * 
	 * @throws ContatoInexistenteException exceção que será lançada caso o contato não exista.
	 */
	public void removerContato(String nomeContato)throws ContatoInexistenteException{
		if( !(this.contatos.containsKey(nomeContato)) ){
			throw new ContatoInexistenteException("Contato " + nomeContato + " nao encontrado.");
		}
		this.contatos.remove(nomeContato);
		System.out.println("Contato "  + nomeContato + " removido.");
		gravaContatos();
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
		if( !(this.contatos.containsKey(nomeContato)) ){
			throw new ContatoInexistenteException("Contato " + nomeContato +" nao cadastrado.");
		}
		return this.contatos.get(nomeContato);
	}

	/**
	 * Método que pega todos os contatos.
	 * 
	 * @return Retorna uma coleção con todos os contatos.
	 * 
	 */
	public Collection<Contato> getContatos(){
		Collection<Contato> c = new ArrayList<Contato>();
		c.addAll(this.contatos.values());
		return c;
	}

	/**
	 * Método que pega todos os contatos, só que ordenados.
	 * 
	 * @return Retorna um iterator com todos os contatos ordenados.
	 * 
	 */
	public Iterator<Contato> getContatosOrdenados(){
		List<Contato> c = new ArrayList<Contato>();
		c.addAll(contatos.values());
		Collections.sort(c);
		return c.iterator();
	}
}
	
