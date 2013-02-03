package Projeto_de_ayla;

public class Desafio {
	
	private String palavraIngles;
	private String dica;
	private String frase;
	
		
	public Desafio(){
		this("","","");
	}
	
	public Desafio(String palavrasIngles, String dica, String frase){
		this.palavraIngles = palavrasIngles;
		this.dica = dica;
		this.frase = frase;
		
	}
	
	public String getPalavraIngles() {
		return palavraIngles;
	}
	public void setPalavraIngles(String palavraIngles) {
		this.palavraIngles = palavraIngles;
	}
	public String getDica() {
		return this.dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	

}
