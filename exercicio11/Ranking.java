package Projeto_de_ayla;

import java.util.*;

public class Ranking {
	
	private List <Jogador> jogadoresDoRanking; 
	private int qtdJogadoresNoRanking;
	
	public Ranking(){
		this.jogadoresDoRanking = new ArrayList <Jogador>(); 
		qtdJogadoresNoRanking = 0;
	}
	
	public void compararJogadorComRanking(Jogador jogador){
		if(qtdJogadoresNoRanking<10){
			jogadoresDoRanking.add(jogador);
			qtdJogadoresNoRanking++;
			ordenarRanking();
		}else if( jogador.getPontuacao() > jogadoresDoRanking.get(qtdJogadoresNoRanking-1).getPontuacao() ){
			jogadoresDoRanking.remove(qtdJogadoresNoRanking-1);
			jogadoresDoRanking.add(jogador);
			ordenarRanking();
		}
	}
	private void ordenarRanking(){
		Collections.sort(jogadoresDoRanking);
		Collections.reverse(jogadoresDoRanking);
	}
	
	public List <Jogador> getDadosDoRanking(){
	
		return jogadoresDoRanking;
	}
		
}
