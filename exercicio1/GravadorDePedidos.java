import java.util.*;
import java.io.*;

public class GravadorDePedidos{

	public GravadorDePedidos(){
	}
	public List<Pedido> lePedido() throws IOException{
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new fileInputStream("pedidos.txt"));
			return (ArrayList<Pedido>)in.readObject();
		}catch(FileNotFoundException e){
			throw new IOException("Arquuivo não encontrado", e);
		}catch(ClassNotFoundException e){
			throw new IOException("Classe não encontrada", e);
		}catch(IOException e){
			throw e;
		}
		finally{
			if(in != null){
				in.close();
			}
		}
		
	}
	public void gravaPedido(List <Pedido> pedidos)throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("pedidos.txt"));
			out.writeObject(pedidos);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontrado",e);
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
}