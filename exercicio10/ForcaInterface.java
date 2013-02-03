package Projeto_de_ayla;

public interface ForcaInterface {
	
	public void criarJogador();
	public void obterDesafio();
	//public char[] obterLetrasErradas();
	public boolean chutarLetra(char letra);
	public boolean chutarPalavra(String palavra);
	public Desafio proximoDesafio();
	public Ranking mostrarRanking();
	public void sair();

}
