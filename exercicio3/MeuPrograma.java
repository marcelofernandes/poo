
public class MeuPrograma {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente("Maria");
		Cliente c3 = new Cliente();
		System.out.println(c1.getNome());
		System.out.println(c2.getNome());
		System.out.println(c3.getNome());
		ItemDePedido itp1 = new ItemDePedido("Coca", 3, 6.0);
		System.out.println(itp1.getValorUnitario());
		Pedido p1 = new Pedido(1000);
		System.out.println(p1.getNumeroPedido());
		System.out.println(p1.getCliente().getNome());
		p1.setCliente(c2);
		System.out.println(p1.getCliente().getNome());
		System.out.println(p1.getItens().size());
		p1.adicionaItem(itp1);
		System.out.println(p1.getItens().size());
		System.out.println(p1.getItens().get(0).getQuantidade()+" "
		
				+p1.getItens().get(0).getCodProduto()+ " e o preço unitário é:"
				+p1.getItens().get(0).getValorUnitario());
		
		
	}

}
