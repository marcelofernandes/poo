import java.io.Serializable;

public class ItemDePedido implements Serializable{
	private int quantidade;
	private long codProduto;
	private double valorUnitario;

	public ItemDePedido(long cod, int quant, double valor){
		this.codProduto = cod;
		this.quantidade = quant;
		this.valorUnitario = valor;
	}
	public int getQuantidade(){
		return this.quantidade;
	}
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	public long getCodProduto(){
		return this.codProduto;
	}
	public void setCodProduto(long codProduto){
		this.codProduto = codProduto;
	}
	public double getValorUnitario(){
		return this.valorUnitario;
	}
	public void setValorUnitario(double valorUnitario){
		this.valorUnitario = valorUnitario;
	}
}