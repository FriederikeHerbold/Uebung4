package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrypterCarsar extends AbstractCrypter {
	/**
	 * Enums zum zuweisen der werte zu den Buchstaben
	 *
	 */
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

	public CrypterCarsar(String key) throws IlligalKeyException {
		checkKey(key);
		this.key = Alphabet.valueOf(key);
	}

	/**
	 * Methode zum überprüfen des Schlüssels auf falsches zeichen. Prüft auch ob
	 * Schlüssel nur 1 zeichen lang
	 * 
	 * @param wert
	 * @throws IlligalKeyException
	 */
	public void checkKey(String wert) throws IlligalKeyException {
		if (wert.length() != 1) {
			throw new IlligalKeyException();
		}
		if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains("" + wert.charAt(0))) {
			throw new IlligalKeyException();
		}

	}

	/**
	 * Methode zum überprüfen der message auf falsche zeichen
	 * 
	 * @param wert
	 * @throws CrypterException
	 */
	public void check(String wert) throws CrypterException {
		for (int index = 0; index < wert.length(); index++) {
			if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains("" + wert.charAt(index))) {
				throw new CrypterException();
			}
		}
	}

	/**
	 * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
	 * 
	 * @param message
	 *            Nachricht, die Verschlüsselt werden soll.
	 * 
	 * @return verschlüsselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             Auftreten.
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		try{
			check(message);
		}
		catch(CrypterException ex){
			message = message.replaceAll("(?u)[^\\pL]", "");
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

	/**
	 * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
	 * 
	 * @param cypterText
	 *            Nachricht, die entschlüsselt werden soll.
	 * 
	 * @return entschlüsselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		try{
			check(cypherText);
		}
		catch(CrypterException ex){
			cypherText = cypherText.replaceAll("(?u)[^\\pL]", "");
		}
		Alphabet temp = null;
		String erg = "";
		int hilf;
		Alphabet[] array = Alphabet.values();
		for (int index = 0; index < cypherText.length(); index++) {
			temp = Alphabet.valueOf("" + cypherText.charAt(index));
			hilf = (temp.wert - key.wert);
			if (hilf <= 0) {
				hilf = hilf + 26;
			}
			erg = erg + array[hilf - 1].name();
		}
		return erg;
	}

}
