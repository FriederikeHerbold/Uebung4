package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrypterCarsar implements Crypter {
	private enum Alphabet {
		A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8), I(9), J(10), K(11),
		L(12), M(13), N(14), O(15), P(16), Q(17), R(18), S(19), T(20), U(21),
		V(22), W(23), X(24), Y(25), Z(26);

		private final int wert;

		private Alphabet(int wert) {

			this.wert = wert;
		}

	}

	private Alphabet key;

	public CrypterCarsar(String key) {
		this.key = Alphabet.valueOf(key);
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		Alphabet temp;
		String erg = "";
		int hilf;
		Alphabet[] array = Alphabet.values();
		for (int index = 0; index < message.length(); index++) {
			temp = Alphabet.valueOf("" + message.charAt(index));
			hilf = (temp.wert + key.wert);
			if (hilf > 26) {
				hilf = hilf - 26;
			}
			erg = erg + array[hilf + 1].name();
		}
		return erg;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> erg = new ArrayList<>();
		Iterable<String> iterable = messages;
		Iterator<String> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			erg.add(encrypt(iterator.next()));
		}
		return erg;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		Alphabet temp= null;
		String erg = "";
		int hilf;
		Alphabet[] array = Alphabet.values();
		for (int index = 0; index < cypherText.length(); index++) {
			temp = Alphabet.valueOf("" + cypherText.charAt(index));
			hilf = (temp.wert - key.wert);
			if (hilf < 1) {
				hilf = hilf +26;
			}
			erg = erg + array[hilf + 1].name();
		}
		return erg;
	}

	@Override
	public List<String> decrypt(List<String> cyrherTexte)
			throws CrypterException {
		ArrayList<String> erg = new ArrayList<>();
		Iterable<String> iterable = cyrherTexte;
		Iterator<String> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			erg.add(decrypt(iterator.next()));
		}
		return erg;
	}

}
