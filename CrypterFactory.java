package ws2014.tpe.gruppe_1415349_1410206.uebung4;

public class CrypterFactory {
	public enum Verschluesselung {
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL;
	}

	public static Crypter createCrypter(String schluessel, Verschluesselung art)
			throws IlligalKeyException {
		switch (art) {
		case CAESAR:
			return new CrypterCarsar(schluessel);
		case SUBSTITUTION:
			return new CrypterSubstitution(schluessel);
		case REVERSE:
			return new Umkehrverschlüsselung();
		case XOR:
			return new CrypterXor(schluessel);
		case NULL:
			return new Nullchiffre();
		default:
			return null;

		}

	}

	public static Crypter createCrypter(Verschluesselung type)
			throws CrypterException {
		switch (type) {
		case REVERSE:
			return new Umkehrverschlüsselung();
		case NULL:
			return new Nullchiffre();
		default:
			throw new CrypterException();
		}
	}
}
