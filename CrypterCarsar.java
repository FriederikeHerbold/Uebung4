package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrypterCarsar implements Crypter {
	private enum Alphabet {
		A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8), I(9), J(10), K(11), L(
				12), M(13), N(14), O(15), P(16), Q(17), R(18), S(19), T(20), U(
				21), V(22), W(23), X(24), Y(25), Z(26);

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
		for (int index = 0; index < message.length(); index++) {
			if (message.charAt(index) > 'Z' || message.charAt(index) < 'A') {
				throw new CrypterException(message.charAt(index));
			}
		}
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
			erg = erg + array[hilf - 1].name();
		}
		return erg;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> erg = new ArrayList<>();
		Iterable<String> iterable = messages;
		Iterator<String> iterator = iterable.iterator();
		String wert = iterator.next();
		while (iterator.hasNext()) {
			for (int index = 0; index < wert.length(); index++) {
				if (wert.charAt(index) > 'Z' || wert.charAt(index) < 'A') {
					throw new CrypterException(wert.charAt(index));
				}
			}
		}
		while (iterator.hasNext()) {
			erg.add(encrypt(iterator.next()));
		}
		return erg;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		for (int index = 0; index < cypherText.length(); index++) {
			if (cypherText.charAt(index) > 'Z'
					|| cypherText.charAt(index) < 'A') {
				throw new CrypterException(cypherText.charAt(index));
			}
		}
		Alphabet temp = null;
		String erg = "";
		int hilf;
		Alphabet[] array = Alphabet.values();
		for (int index = 0; index < cypherText.length(); index++) {
			temp = Alphabet.valueOf("" + cypherText.charAt(index));
			hilf = (temp.wert - key.wert);
			if (hilf < 0) {
				hilf = hilf + 26;
			}
			erg = erg + array[hilf - 1].name();
		}
		return erg;
	}

	@Override
	public List<String> decrypt(List<String> cyrherTexte)
			throws CrypterException {
		ArrayList<String> erg = new ArrayList<>();
		Iterable<String> iterable = cyrherTexte;
		Iterator<String> iterator = iterable.iterator();
		String wert = iterator.next();
		while (iterator.hasNext()) {
			for (int index = 0; index < wert.length(); index++) {
				if (wert.charAt(index) > 'Z' || wert.charAt(index) < 'A') {
					throw new CrypterException(wert.charAt(index));
				}
			}
		}
		while (iterator.hasNext()) {
			erg.add(decrypt(iterator.next()));
		}
		return erg;
	}

	public static void main(String[] args) {
		CrypterCarsar nul = new CrypterCarsar("G");
		String message = "ABCDE";
		String erg = "";
		String erg2 = "";
		while (erg.equals("") && erg2.equals("")) {
			try {
				erg = nul.encrypt(message);
				erg2 = nul.decrypt(erg);

			} catch (CrypterException ex) {
				message = message.toUpperCase();
				for (int index = 0; index < message.length(); index++) {
					message = message.replaceAll("(?u)[^\\pL]", "");
				}
			}
		}
		System.out.println(message);
		System.out.println(erg);
		System.out.println(erg2);
	}
}
