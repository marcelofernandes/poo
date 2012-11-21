import java.util.List;
public interface InterfaceSistemaDeControle{
	public void adicionaPedido(Pedido p);
	public List<Pedido> pesquisaPedidosIncuindoProduto(long codProduto);
	public void removePedido(long numPedido);
}