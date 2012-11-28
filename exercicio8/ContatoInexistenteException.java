package br.ufpb.sistemadeagenda;

public class ContatoInexistenteException extends Exception{
	public ContatoInexistenteException(){
		this("O contato nao foi encontrado na agenda.");
	}
	public ContatoInexistenteException(String m){
		super(m);
	}
}