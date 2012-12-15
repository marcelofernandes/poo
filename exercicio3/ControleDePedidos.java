import java.util.*;

/**
 * Classe para controle de pedidos.
 * 
 * @author Marcelo Fernandes
 * 
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List <Pedido> pedidos;
	
	/**
	 * Construtor para que inicializa a variável pedidos.
	 * 
	 */
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	
	/**
	 * Método que calcula a quantidade de pedidos de determinado cliente.
	 * 
	 * @param nomeCliente O nome do cliente cuja quantidade de pedidos vai ser calculada.
	 * 
	 * @return Retorna a quantidade de pedidos desse cliente.
	 * 
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
	
	/**
	 * Método para adicionar um pedido.
	 * 
	 * @param p O pedido a ser adicionado.
	 * 
	 */
	@Override
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);

	}

	/**
	 * Método para pesquisar pedidos que possuem determinado produto.
	 * 
	 * @param codProduto O codigo do produto a ser pesquisado.
	 * 
	 * return Retorna a lista com os pedidos que possuem o produto.
	 * 
	 */
	@Override
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto) {
		List <Pedido> pedidosProcurados = new LinkedList<Pedido>();
		for (Pedido p: this.pedidos){
			for (ItemDePedido item : p.getItens()){
				if (item.getCodProduto().equals(codProduto)){
					pedidosProcurados.add(p);
					break;
				}
			}
		}
		return pedidosProcurados;
	}

	/**
	 * Método para remover um pedido.
	 * 
	 * @param numeroPedido O numero do pedido a ser removido.
	 * 
	 */
	@Override
	public void removePedido(long numeroPedido) {
		for (Pedido p: this.pedidos){
			if (p.getNumeroPedido()== numeroPedido){
				this.pedidos.remove(p);
				return;
			}
		}

	}

}
