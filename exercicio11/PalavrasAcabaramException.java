public class PalavrasAcabaramException extends Exception{

	public PalavrasAcabaramException(){
		this("Parabéns, você chegou ao final do jogo!");
	}

	public PalavrasAcabaramException(String mensagem){
		super(mensagem);
	}
}