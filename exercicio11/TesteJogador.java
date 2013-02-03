package Projeto_de_ayla;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteJogador {
	
	//testando a classe Jogador
	
			
	private Jogador jogadorA;
	private Jogador jogadorB;
			
	@Test 
	public void criaJogador(){
		
		//default
		jogadorA = new Jogador();
		assertEquals("", jogadorA.getNome());
		assertTrue(jogadorA.getNome().equals(""));
		
		//com parâmetros
		jogadorB = new Jogador("Lucas");
		assertEquals("Lucas", jogadorB.getNome());
		assertTrue(jogadorB.getNome().equals("Lucas"));
		
		//troca de nome
		jogadorA.setNome("BruNO");
		assertEquals("BruNO", jogadorA.getNome());
		
		jogadorB.setNome("RAFAEL");
		assertEquals("RAFAEL", jogadorB.getNome());
		
		//valores da pontuação
		assertEquals(0, jogadorA.getPontuacao());
		assertEquals(0, jogadorB.getPontuacao());
		
		jogadorA.setPontuacao(12);
		jogadorB.setPontuacao(50);
		
		assertEquals(12, jogadorA.getPontuacao());
		assertEquals(50, jogadorB.getPontuacao());
		
		
		
		
		
		
		
	}
	
	

}
