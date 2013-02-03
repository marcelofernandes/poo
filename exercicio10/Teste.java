package Projeto_de_ayla;

import static org.junit.Assert.*;
import org.junit.Test;

public class Teste {
	
	@Test
	public void testaGerenteDePersistencia(){
		GerenteDePersistencia gerente = new GerenteDePersistencia();
		assertTrue(gerente.getFrase()=="");
		assertTrue(gerente.getPalavraIngles()=="");
		assertEquals(gerente.getPalavraPortugues(),"");
	}
	
	@Test
	public void testaDesafio(){
		Desafio desafio = new Desafio("ingles","portugues","frase");
		assertTrue(desafio.getFrase()=="frase");
		assertTrue(desafio.getPalavrasPortugues().equals("portugues"));
		assertEquals(desafio.getPalavraIngles(),"ingles");
	}
}
