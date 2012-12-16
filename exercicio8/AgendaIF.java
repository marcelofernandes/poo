package br.ufpb.sistemadeagenda;

import java.util.*;

/**
 * Interface com métodos para controle de contatos de uma agenda.
 * 
 * @author Marcelo Fernandes.
 *
 */
public interface AgendaIF{

	/**
	 * Adiciona um contato a lista de contatos.
	 * 
	 * @param nome � o nome do contato que ser� adicionado.
	 *
	 * @param tel � o telefone do contato que ser� adicionado.
	 */
	public void adicionarContato(String nome, String tel);

	/**
	 * Remove um contato da lista de contatos.
	 * 
	 * @param nomeContato � o nome do contato que ser� removido.
	 *
	 * @throws ContatoInexistenteException Exce��o caso o contato n�o exista.
	 */
	public void removerContato(String nomeContato)throws ContatoInexistenteException;

	/**
	 * Pesquisa se tem um determinado contato na lista.
	 * 
	 * @param nomeContato nome do contato a ser pesquisado.
	 * 
	 * @return Retorna o contato pesquisado.
	 *
	 * @throws ContatoInexistenteException Exce��o caso o contato n�o exista.
	 */
	public Contato pesquisarContato(String nomeContato)throws ContatoInexistenteException;

	/**
	 *  Metodo para pegar todos os contatos.
	 * 
	 * @return Retorna uma colecao com todos os contatos.
	 */
	public Collection<Contato> getContatos();

	/**
	 *  Metodo para pegar todos os contatos ordenados.
	 * 
	 * @return Retorna um iterator com todos os contatos.
	 */
	public Iterator<Contato> getContatosOrdenados();
}
