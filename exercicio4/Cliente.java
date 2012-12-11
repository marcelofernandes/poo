package br.ufpb.sistemapedidos;

public class Cliente {

	private String nome;
	
	public Cliente(){
		this("Fulano");
	}
	public Cliente(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
}
