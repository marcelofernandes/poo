import java.util.Scanner;

public class Principal{
	private static Scanner input = new Scanner(System.in);
	public static void main(String [] args){
		Pedido pedido = new Pedido(1);
		for(String cod = getCod(); !(cod.equals("0")); cod = getCod()){
			int qtd = input.nextInt();
			double valor = input.nextDouble();
			ItemDePedido item = new ItemDePedido(cod, qtd, valor);
			pedido.adicionaItem(item);
		}
		imprimeTotalDoPedido(pedido);
	}
	public static String getCod(){
		mostraMensagem();
		return input.next();
	}
	public static void mostraMensagem(){
		System.out.println("Digite o codigo do produto, a quantidade "
				+ "e o preco do item, zero para sair.");
	}
	public static void imprimeTotalDoPedido(Pedido p){
		 System.out.println("Valor total: " + p.getValorTotal());
	}
}
