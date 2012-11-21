import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GravadorDePedidos{

	public GravadorDePedidos(){
	}
	public List<Pedido> lePedido() throws IOException,ClassNotFoundException{
		List<Pedido> lista = new ArrayList<Pedido>();
		FileInputStream arquivoLeitura = new FileInputStream("C:/arquivo.dat");
		ObjectInputStream in = new ObjectInputStream(arquivoLeitura);
		lista = (ArrayList<Pedido>)in.readObject();
		arquivoLeitura.close();
		in.close();
		return lista;
		
	}
	public void gravaPedido(List <Pedido> pedidos)throws IOException{
		FileOutputStream arquivoGravar = new FileOutputStream("C:/arquivo.dat");
		ObjectOutputStream out = new ObjectOutputStream(arquivoGravar);
		out.writeObject(pedidos);
		arquivoGravar.close();
		out.close();
	}
}