import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Classe para o controle de pedidos.
 * 
 * @author Marcelo Fernandes
 * 
 */
public class ControleDePedidos implements InterfaceSistemaDeControle{
	private List<Pedido> pedidos;
	private GravadorDePedidos gravador;

	/**
	 * Construtor padrão da classe ControleDePedidos que inicializa as variáveis.
	 * 
	 */
	public ControleDePedidos(){
		gravador = new GravadorDePedidos();
		carregaPedidos();
	}	
	
	/**
	 * Método para gravar os pedidos no disco.
	 * 
	 */
	public void gravaPedidos(){
		try{
			gravador.gravaPedido(pedidos);
		}
		catch(IOException ioException){
			System.out.println("Os dados nao puderam ser gravados");
		}
	}
	
	/**
	 * Método para carregar os pedidos do disco.
	 * 
	 */
	private void carregaPedidos(){
		try{
			pedidos = gravador.lePedido();
		}
		catch(IOException ioException){
			this.pedidos = new ArrayList<Pedido>();
			System.out.println("Os dados nao puderam ser movidos");
		}
	}
	
	/**
	 * Método que calcula a quantidade de pedidos de um determinado cliente.
	 * 
	 * @param nomeCliente É o nome do cliente a ser pesquisado.
	 * 
	 * @return Retirna a quantidade de pedidos desse cliente.
	 * 
	 */
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int qtd = 0;
		for(Pedido p: this.pedidos){
			if(p.getCliente().getNome().equals(nomeCliente)){
				qtd++;
			}
		}
		return qtd;
	}
	
	/**
	 * Método para adicionar pedido.
	 * 
	 * @param p O pedido a ser adicionado.
	 * 
	 */
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	
	/**
	 * Método que pesquisa pedidos que incluam determinado produto.
	 * 
	 * @param codProduto O codigo do produto a ser pesquisado.
	 * 
	 * return Retorna uma lista com os pedidos que contem o produto.
	 * 
	 */
	public List<Pedido> pesquisaPedidosIncuindoProduto(long codProduto){
		List<Pedido> aux = new ArrayList<Pedido>();
		for(Pedido p: this.pedidos){
			for(ItemDePedido item: p.getItens()){
				if(item.getCodProduto() == codProduto){
					aux.add(p);
					break;
				}
			}
		}
		return aux;
	}
	
	/**
	 * Método para remover um pedido
	 * 
	 * @param numPedido O numero do pedido a ser removido.
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
