package Projeto_de_ayla;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class TesteRanking {
	
	private Ranking ranking = new Ranking(); 
	private String []nomes = {"Lucas","Pedro","Ana","Maria","Jorge","Ricardo",
			"Eduardo","Carlos","Gil","Rafael","Júlia","Carla"};
	private Jogador []jogadores = new Jogador[12];
	private int [] pontos = {200,100,50,150,560,670,890,432,765,78,324,760};
	
	
	@Test
	public void TesteRanking(){
	
		for(int i=0;i<nomes.length;i++){
			jogadores[i]= new Jogador(nomes[i]);
			jogadores[i].setPontuacao(pontos[i]);
			ranking.compararJogadorComRanking(jogadores[i]);
		}
		
		//testando o método de ordenação dos jogadores
		List <Jogador> busca =  ranking.getDadosDoRanking();
		
		//testando o nome e a pontuação do jogador do topo da lista
		assertEquals("Eduardo",busca.get(0).getNome());
		assertEquals(890,busca.get(0).getPontuacao());
		
		
		//testando o método de comparação de jogadores
		Jogador jogadorMaior = new Jogador("Fernando");
		jogadorMaior.setPontuacao(1000);
		
		ranking.compararJogadorComRanking(jogadorMaior);	
		
		assertEquals("Fernando",busca.get(0).getNome());
		assertEquals(1000,busca.get(0).getPontuacao());
		
		
			
			
		}
	

}
