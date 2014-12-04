package ws2014.tpe.gruppe_1415349_1410206.uebung4;

public class CrypterFactory {
	public enum Verschluesselung {
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL;
	}
	public Verschluesselung createCrypter(String Schlüssel){
		return Verschluesselung.NULL;
	}
}
