import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public interface BancoDeDados implements PersistenciaInterface{
	
	private static final BancoDeDados banco = new BancoDeDados();
	private static final String DATABASE_URL = "jdbc:mysql://localhost/forca";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private int indiceAtual;
	private ArrayList <Integer> lista ;

	private BancoDeDados banco(){
		lista = new ArrayList<Integer>();
		iniciaLista();
		indiceAtual = 0;
		conectarAoBanco();
	}
	
	public static BancoDeDados getBanco(){
		return this.banco;
	}
	
	public void iniciarLista(){
		for(int i = 1; i<=100; i++){
			lista.add(i);
		}
		Collections.shuffle(lista);
	}
		
	public void conectarAoBanco(){
		try{
			connection = DriverManager.getConnection ( DATABASE_URL,"forca","forca" ); 
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * FROM dados");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public void desconectar(){
		try{
			resultSet.close();
			statement.close();
			connection.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public String getPalavraPortugues(){
		try {
			resultSet.absolute(lista.get(indiceAtual));
			return (String)resultSet.getObject(3);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"dica não encontrada.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
	
	public String getPalavraIngles(){
		try {
			return (String)resultSet.getObject(2);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"palavra em inglês não encontrada");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
	
	public String getFrase(){
		try {
			String frase = (String)resultSet.getObject(4);
			indiceAtual++;
			return frase;
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"frase não encontrada");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}

	public String getAudioDaPalavra(){
		try {
			resultSet.absolute(lista.get(indiceAtual));
			return (String)resultSet.getObject(5);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"audio não encontrado.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}

	public String getAudioDaFrase(){
		try {
			resultSet.absolute(lista.get(indiceAtual));
			return (String)resultSet.getObject(6);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"audio não encontrado.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
}