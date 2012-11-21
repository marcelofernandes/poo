package br.ufpb.sistemapedidos;

import java.util.List;

/**
 * Interface com métodos para controle de pedidos de um restaurante.
 * 
 * @author Marcelo Fernandes.
 *
 */
public interface InterfaceSistemaDeControle {

	/**
	 * Adiciona um pedido a lista de pedidos.
	 * 
	 * @param p É o pedido que será adicionado.
	 */
	public void adicionaPedido(Pedido p);

	/**
	 * Pesquisa por pedidos que contenham um certo produto.
	 * 
	 * @param codProduto Codigo do produto a ser pesquisado.
	 * 
	 * @return Retorna uma lista com os produtos que tenham o codigo especificado.
	 */
	public List <Pedido> pesquisaPedidosIncluindoProduto(String codProduto);

	/**
	 * Remove um pedido da lista de pedidos.
	 * 
	 * @param numPedido Numero do pedido a ser removido
	 */
	public void removePedido(long numeroPedido);
}
