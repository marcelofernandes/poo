import java.util.*;


public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List <Pedido> pedidos;
	
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int cont = 0;
		for (Pedido p: this.pedidos){
			if (p.getCliente().getNome().equals(nomeCliente)){
				cont++;
			}
		}
		return cont;
	}
	
	@Override
	public void adicionaPedido(Pedido p) {
		this.pedidos.add(p);

	}

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
