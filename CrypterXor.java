package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CrypterXor extends AbstractCrypter {
	/**
	 * Enums um den Zeichen über die Ordinalzahlen werte zuzuweisen
	 *
	 */
	private enum Alphabet {
		AA('@'), A('A'), B('B'), C('C'), D('D'), E('E'), F('F'), G('G'), H('H'), I(
				'I'), J('J'), K('K'), L('L'), M('M'), N('N'), O('O'), P('P'), Q(
				'Q'), R('R'), S('S'), T('T'), U('U'), V('V'), W('W'), X('X'), Y(
				'Y'), Z('Z'), Z2('['), Z3('\\'), Z4(']'), Z5('^'), Z6('_');

		private final char zeichen;

		private Alphabet(char zeichen) {

			this.zeichen = zeichen;
		}

	}

	List<Alphabet> buchstaben;
	String keys;

	public CrypterXor(String key) throws IlligalKeyException {
		checkKey(key);
		buchstaben = Arrays.asList(Alphabet.values());
		this.keys = key;
	}

	/**
	 * Methode zum überprüfen des Schlüssels auf ungültige zeichen
	 * 
	 * @param wert
	 * @throws IlligalKeyException
	 */
	public void checkKey(String wert) throws IlligalKeyException {
		for (int index = 0; index < wert.length(); index++) {
			if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZ@[\\]^_".contains(""
					+ wert.charAt(index))) {
				throw new IlligalKeyException();
			}
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
			if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZ@[\\]^_".contains(""
					+ wert.charAt(index))) {
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
	public String encrypt(String message) throws CrypterException {
		check(message);
		int wert;
		String erg = "";
		int wertZeichen;
		int wertKey;
		int hilf;
		Alphabet temp;
		int keyIndex = 0;
		Iterable<Alphabet> iterable = buchstaben;

		for (int index = 0; index < message.length(); index++) {
			if (keyIndex >= keys.length()) {
				keyIndex = keyIndex - keys.length();
			}
			wertKey = keys.charAt(keyIndex) - 'A' + 1;
			keyIndex++;
			Iterator<Alphabet> iterator = iterable.iterator();
			do {
				hilf = 100;
				temp = iterator.next();
				if (temp.zeichen == message.charAt(index)) {
					wertZeichen = temp.ordinal();
					hilf = wertZeichen ^ wertKey;
					erg = erg + buchstaben.get(hilf).zeichen;
				}
			} while (iterator.hasNext() && hilf == 100);
		}
		return erg;
	}

	/**
	 * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel. Ruft
	 * encrypt(String), da decrypten und encrypten bei Xor identisch.
	 * 
	 * @param cypterText
	 *            Nachricht, die entschlüsselt werden soll.
	 * 
	 * @return entschlüsselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */

	public String decrypt(String cypherText) throws CrypterException {
		return encrypt(cypherText);
	}

	public static void main(String[] args) {
		CrypterXor nul = null;
		try {
			nul = new CrypterXor("TPERULES");
		} catch (IlligalKeyException ex) {
			System.out.println("falscher Schlüssel\n");
		}
		String message = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String erg = "";
		String erg2 = "";
		while (erg == "" && erg2 == "") {
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
