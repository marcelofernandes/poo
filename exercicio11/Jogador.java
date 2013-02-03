package Projeto_de_ayla;

public class Jogador implements Comparable <Jogador> {

	private String nome;
	private int pontuacao;
	
	public Jogador(){
		this("");
	}
	
	public Jogador(String nome){
		this.nome = nome;
		this.pontuacao = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String toString(){
		return this.nome +" "+ this.pontuacao;
		
	}
	
	@Override
	public int compareTo(Jogador jogador){
		if(this.pontuacao>jogador.pontuacao){
			return 1;
		}
		else if(this.pontuacao == jogador.pontuacao){
			return 0;
		}
		else{
			return -1;
		}
	}
}
