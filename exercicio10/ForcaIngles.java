package Projeto_de_ayla;

public class ForcaIngles implements ForcaInterface {
	
	private Jogador jogador;
	private Desafio desafio;
	private Ranking ranking;
	private InterfaceDePersistencia gerente;
	
	public ForcaIngles(){
		gerente = GerenteDePersistencia.getGerente();
		ranking = new Ranking();
		desafio = obterDesafio();
	}
	
	public void criarJogador(String nome) {
		this.jogador = new Jogador(nome);
				
	}
	
	public void obterDesafio() {
		this.desafio = new Desafio (gerente.getPalavraIngles(), gerente.getPalavrasPortuges(), gerente.getFrase());
						
	}
		
	public boolean verificarLetra(char letra) {
		String palavra = this.desafio.getPalavraIngles(); 
		for(int i= 0 ; i< palavra.length(); i++){
			if(palavra.charAt(i)== letra){
				return true;
			}
		}
		return false;
	}


	public boolean verificarPalavra(String palavra) {
		return (this.desafio.getPalavraIngles().equals(palavra))
	}

	
	public String getDadosDoRanking() {
		return rankig.getDadosDoRanking();
	}
	
	public String getDica(){
		return desafio.getDica();
	}
	
	public String getNomeDoJogador(){
		return jogador.getNome();
	}
	
	public int getPontuacaoDoJogador(){
		return jogador.getPontuacao();
	}
	
	public int getQuantidadeDeEspacos(){
		return jogador.getPalavraIngles().length;
	}

	public void iniciar(){
		//TODO
	}
	public void sair() {
		//TODO
	}

}
