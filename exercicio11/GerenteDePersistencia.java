package Projeto_de_ayla;

public class GerenteDePersistencia{
	
	PersistenciaInterface persistencia;
	
	public GerenteDePersistencia(){
		persistencia = BancoDeDados.getBanco();
	}
	
	public String getDica(Nivel nivel){
		if( nivel == Nivel.FACIL){
			return persistencia.getPalavraPortugues();
		}else{
			return persistencia.getAudioDaPalavra();
		}
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
	
}
