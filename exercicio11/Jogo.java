public class Jogo{

	ForcaIngles forca;
	InterfaceComUsuario interface;

	public Jogo(){
		forca = new Forca();
		interface = new InterfaceTexto();
	}

	public static void main(String ... args){
		Jogo jogo = new Jogo();
		jogo.run();
	}
	
	public void iniciar(){
		interface.mostrarMenu();
		interface.escolherNivel();
		interface.nomeDoJogador();
		interface.iniciarJogo();
	}
}