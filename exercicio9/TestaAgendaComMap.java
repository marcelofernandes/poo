package br.ufpb.sistemadeagenda;

import java.util.*;
import javax.swing.*;

public class TestaAgendaComMap{
	public static void main(String [] args){
		AgendaIF agenda = new AgendaMap();
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
						JOptionPane.showMessageDialog(null, "Nome: " + c.getNome() + "\nTelefone: " + c.getTelefone());
					}catch(ContatoInexistenteException e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					break;
				case 4:
					Collection<Contato> c = agenda.getContatos();
					for(Contato contato: c){
						System.out.println("Nome: " + contato.getNome() + " Tel: " + contato.getTelefone());
					}
					break;
				case 5:
					Iterator<Contato> it = agenda.getContatosOrdenados();
					while(it.hasNext()){
						Contato cont = it.next();
						System.out.println("Nome: " + cont.getNome() + " Tel: " + cont.getTelefone());
					}
					
			}
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite 1- adicionar, 2- remover, 3-consultar, 4-mostrar todos os contatos, 5- mostrar todos os contatos ordenados, 6-sair:"));
		}while(op<6);
	}
}