package br.ufpb.sistemadepedidos;

import java.io.Serializable;

public class Cliente implements Serializable{
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
	public void setNome(String nome){
		this.nome = nome;
	}
}
