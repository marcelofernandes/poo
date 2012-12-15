import java.util.List;

/**
 * Interface para controle de pedidos.
 * 
 * @author Marcelo Fernandes
 * 
 */
public interface InterfaceSistemaDeControle {
	
	/**
	 * Método para adicionar um pedido.
	 * 
	 * @param p O pedido a ser acicionado.
	 * 
	 */
	public void adicionaPedido(Pedido p);
	
	/**
	 * Método para pesquisar os pedidos que contem determinados produtos.
	 * 
	 * @param codProduto O codigo do produto a ser perquisado.
	 * 
	 * @return Retorna a lista de pedidos que contem o produto.
	 * 
	 */
	public List <Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	
	/**
	 * Método para remover um pedido.
	 * 
	 * @param numeroPedido O número do pedido a ser removido.
	 * 
	 */
	public void removePedido(long numeroPedido);
}
