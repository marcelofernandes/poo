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
	 * Construtor padrão que inicializa a lista.
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
	
	/**
	 * Método para carregar os pedidos do arquivo.
	 * 
	 */
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
	 * @return Retorna a quantidade de pedidos do cliente passado como parâmetro.
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
	
	/**
	 * Método para adicionar um pedido.
	 * 
	 * @param p O pedido a ser adicionado.
	 * 
	 */
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	
	/**
	 * Método para pesquisar pedidos que possuem determinado produto.
	 * 
	 * @param codProduto O codigo do produto a ser pesquisado.
	 * 
	 * @return a lista com os pediso que contem o produto.
	 * 
	 */
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
	
	/**
	 * Método para remover um pedido.
	 * 
	 * @param numPedido O número do pedido a ser removido.
	 * 
	 */
	public void removePedido(long numPedido){
		for(Pedido p: this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(p);
				return;
			}
		}
	}
}
