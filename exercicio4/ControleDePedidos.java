package br.ufpb.sistemapedidos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe concreta que serve para controlar os pedidos de um restaurante.
 * 
 * @author Marcelo Fernandes.
 *
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List <Pedido> pedidos;
	
	/**
	 * Construtor padr�o que inicializa o ArrayList.
	 * 
	 */
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
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
		int cont = 0;
		for (Pedido p: this.pedidos){
			if (p.getCliente().getNome().equals(nomeCliente)){
				cont++;
			}
		}
		return cont;
	}
	
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);

	}

	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) {
		List <Pedido> pedidosProcurados = new LinkedList<Pedido>();
		for (Pedido p: this.pedidos){
			for (ItemDePedido it: p.getItens()){
				if (it.getCodProduto().equals(codProduto)){
					pedidosProcurados.add(p);
					break;
				}
			}
		}
		return pedidosProcurados;
	}

	public void removePedido(long numeroPedido) {
		for (Pedido p: this.pedidos){
			if (p.getNumeroPedido() == numeroPedido){
				this.pedidos.remove(p);
				return;
			}
		}

	}

}
