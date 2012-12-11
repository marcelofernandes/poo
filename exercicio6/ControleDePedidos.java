package br.ufpb.sistemadepedidos;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Classe concreta que serve para controlar os pedidos de um restaurante.
 * 
 * @author Marcelo Fernandes.
 *
 */
public class ControleDePedidos implements InterfaceSistemaDeControle{
	private List<Pedido> pedidos;
	private GravadorDePedidos gravador;

	/**
	 * Construtor padr�o que inicializa a lista.
	 * 
	 */
	public ControleDePedidos(){
		gravador = new GravadorDePedidos();
		carregaPedidos();
	}	
	
	/**
	 * Metodo para salvar os pedidos em arquivo.
	 * 
	 */
	public void salvarPedidos(){
		try{
			gravador.gravaPedido(pedidos);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		
		
	}
	private void carregaPedidos(){
		try{
			pedidos = gravador.lePedido();
		}
		catch(IOException e){
			System.err.println(e.getMessage());
			System.out.println("Foi criado um novo arquivo.");
			this.pedidos = new ArrayList<Pedido>();
		}
	}

	/**
	 * Calcula a quantidade de pedidos de um determinado cliente.
	 * 
	 * @param NomeCliente Nome do cliente que 
	 * queremos calcular a quantidade de pedidos
	 * 
	 * @return Retorna a quantidade de pedidos do cliente passado como par�metro.
	 */
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int qtd = 0;
		for(Pedido p: this.pedidos){
			if(p.getCliente().getNome() == nomeCliente){
				qtd++;
			}
		}
		return qtd;
	}
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	public List<Pedido> pesquisaPedidosIncuindoProduto(long codProduto){
		List<Pedido> aux = new ArrayList<Pedido>();
		for(Pedido p: this.pedidos){
			for(ItemDePedido item : p.getItens()){
				if(item.getCodProduto() == codProduto){
					aux.add(p);
					break;
				}
			}
		}
		return aux;
	}
	public void removePedido(long numPedido){
		for(Pedido p: this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(p);
				return;
			}
		}
	}
}