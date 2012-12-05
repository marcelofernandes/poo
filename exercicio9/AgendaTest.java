package br.ufpb.sistemadeagenda;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class AgendaTest{
	Agenda agenda;

	@Before
	
	public void setUp() {
		
		agenda = new Agenda();
	
	}



	@Test
	public void testaAgenda(){	
		agenda.adicionarContato("José", "333");
	
		try {
			
			Contato c = agenda.pesquisarContato("José");

			assertTrue( c.getNome().equals("José"));

			assertEquals("333", c.getTelefone());

		} catch (ContatoInexistenteException e) {
	
			fail("Não deveria lançar exceção pois José está cadastrado");

		}
		
			
		try {
			
			agenda.removerContato("José");

		} catch (ContatoInexistenteException e) {

			fail("Não deveria lançar exceção pois existe o contato José");

		}
		
			
		try {
			
			agenda.pesquisarContato("José");

			fail("Programa com erro pois deveria ter lançado a exceção");
		
		} catch (ContatoInexistenteException e) {

			//ok
		}
	
		agenda.adicionarContato("José","888");
	
		try {
			
			Contato c2 = agenda.pesquisarContato("José");

			assertTrue(c2.getNome().equals("José"));

			assertEquals("888", c2.getTelefone());

		} catch (ContatoInexistenteException e) {

			fail("Não deveria lançar exceção pois José está cadastrado");

		}

	}
}
