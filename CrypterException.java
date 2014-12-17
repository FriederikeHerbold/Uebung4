package ws2014.tpe.gruppe_1415349_1410206.uebung4;

public class CrypterException extends Exception {
	private char symbol;

	public CrypterException(){
		
	}
	
	public CrypterException(char symbol) {
		super();
		this.symbol = symbol;

	}

	public char getSymbol() {
		return this.symbol;

	}
}
