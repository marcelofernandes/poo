import java.util.List;

/**
 * Interface par controle de pedidos.
 * 
 * @author Marcelo Fernandes
 * 
 */
public interface InterfaceSistemaDeControle{
	
	/**
	 * Metodo para aicionar um pedido.
	 * 
	 * @param p Pedido a ser adicionado.
	 * 
	 */
	public void adicionaPedido(Pedido p);
	
	/**
	 * Metodo que pesquisa determinados pedidos.
	 * 
	 * @param codProduto O código do produto a ser pesquisado.
	 * 
	 * @return Retorna uma lista com os pedidos encontrados.
	 * 
	 */
	public List<Pedido> pesquisaPedidosIncuindoProduto(long codProduto);
	
	/**
	 * Metodo para remover um determinado pedido.
	 * 
	 * @param numPedido O numero do pedido a ser removido
	 * 
	 */
	public void removePedido(long numPedido);
}
