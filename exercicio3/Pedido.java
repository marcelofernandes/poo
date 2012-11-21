import java.util.LinkedList;
import java.util.List;


public class Pedido {

	private long numeroPedido;
	private Cliente cliente;
	private List <ItemDePedido> itens;
	
	public Pedido(long numeroDoPedido){
		this.numeroPedido = numeroDoPedido;
		this.cliente = new Cliente();
		this.itens = new LinkedList<ItemDePedido>();
	}
	
	public long getNumeroPedido(){
		return this.numeroPedido;
	}
	
	public void adicionaItem(ItemDePedido it){
		this.itens.add(it);
	}
	
	public List<ItemDePedido> getItens(){
		return this.itens;
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}
	
	public void setCliente(Cliente c){
		this.cliente = c;
	}
	
	public void setNumeroDoPedido(long numero){
		
		this.numeroPedido = numero;
	}
	
	public double getValorTotal(){
		double total = 0;
		/*for (ItemDePedido it: this.itens){
			total+= it.getSubTotal(); 
		}*/
		for (int k=0; k< this.itens.size(); k++){
			ItemDePedido it = this.itens.get(k);
			total+=it.getSubTotal();
		}
		return total;
	}
	
	
	
	
	
	
	
	
	
	
	
}
