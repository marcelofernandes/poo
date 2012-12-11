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
		agenda.adicionarContato("Jos�", "333");
	
		try {
			Contato c = agenda.pesquisarContato("Jos�");
			assertTrue( c.getNome().equals("Jos�"));
			assertEquals("333", c.getTelefone());
		} catch (ContatoInexistenteException e) {
			fail("N�o deveria lan�ar exce��o pois Jos� est� cadastrado");
		}
		try {
			agenda.removerContato("Jos�");
		} catch (ContatoInexistenteException e) {
			fail("N�o deveria lan�ar exce��o pois existe o contato Jos�");
		}
		try {	
			agenda.pesquisarContato("Jos�");
			fail("Programa com erro pois deveria ter lan�ado a exce��o");
		} catch (ContatoInexistenteException e) {
			//ok
		}
		agenda.adicionarContato("Jos�","888");
		try {
			Contato c2 = agenda.pesquisarContato("Jos�");
			assertTrue(c2.getNome().equals("Jos�"));
			assertEquals("888", c2.getTelefone());
		} catch (ContatoInexistenteException e) {
			fail("N�o deveria lan�ar exce��o pois Jos� est� cadastrado");
		}
	}
}
