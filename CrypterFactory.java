package ws2014.tpe.gruppe_1415349_1410206.uebung4;

public class CrypterFactory {
	public enum Verschluesselung {
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL;
	}
	
	public Crypter createCrypter(String schluessel, Verschluesselung art){
		switch (art){
		case CAESAR: 
			return new CrypterCarsar(schluessel);
		case SUBSTITUTION:
			return new CrypterSubstitution(schluessel);
		case REVERSE:
			return new CrypterReverse(schluessel);
		case XOR:
			return new CrypterXor(schluessel);
		case NULL:
			return new CrypterNull(schluessel);
		default:
			return null;
			
		}
		
	}
}
