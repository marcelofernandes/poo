package br.ufpb.sistemadeagenda;

import java.util.*;
import javax.swing.*;

public class ProgramaPrincipal{
	public static void main(String [] args){
		String tipo = JOptionPane.showInputDialog("Qual agenda deseja usar? 1- List, 2- Map.");
		int t = Integer.parseInt(tipo);
		AgendaIF agenda;
		if(t == 1){
			agenda = new Agenda();
		}
		else{
			agenda = new AgendaMap();	
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog("Digite 1- adicionar, 2- remover, 3-consultar, 4-mostrar todos os contatos, 5- mostrar todos os contatos ordenados, 6-sair:"));
		do{
			switch(op){
				case 1:
					agenda.adicionarContato(JOptionPane.showInputDialog("Digite o seu nome:"),
					JOptionPane.showInputDialog("Digite o seu telefone:"));
					break;
				case 2:
					try{
						agenda.removerContato(JOptionPane.showInputDialog("Digite o nome do contato para remover:"));
					}catch(ContatoInexistenteException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 3:
					try{
						Contato c = agenda.pesquisarContato(JOptionPane.showInputDialog("Digite o seu nome do contato a pesquisar:"));
						JOptionPane.showMessageDialog(null, c);
					}catch(ContatoInexistenteException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 4:
					Collection<Contato> c = agenda.getContatos();
					for(Contato contato: c){
						System.out.println(contato);
					}
					break;
				case 5:
					Iterator<Contato> it = agenda.getContatosOrdenados();
					while(it.hasNext()){
						System.out.println(it.next());
					}
					
			}
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite 1- adicionar, 2- remover, 3-consultar, 4-mostrar todos os contatos, 5- mostrar todos os contatos ordenados, 6-sair:"));
		}while(op<6);
	}
}

