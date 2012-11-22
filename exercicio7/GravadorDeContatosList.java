package br.ufpb.sistemadeagenda;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GravadorDeContatosList{

	public GravadorDeContatosList(){
	}
	public List<Contato> leContato() throws IOException{
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("contatosList.txt"));
			return (ArrayList<Contato>)in.readObject();
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo nao encontrado",e);
		}catch(ClassNotFoundException e){
			throw new IOException("Classe nao encontrada",e);
		}catch(IOException e){
			throw e;
		}finally{
			if(in != null){
				in.close();
			}
		}
	}
	public void gravaContato(List <Contato> pedidos)throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatosList.txt"));
			out.writeObject(pedidos);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo nao encontrado", e);
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
}