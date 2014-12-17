package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrypterSubstitution extends AbstractCrypter {
	// Liste zum realisieren des Schl�ssels
	List liste = new ArrayList();

	public CrypterSubstitution(String key) throws IlligalKeyException {
		checkKey(key);
		String hilf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int index = 0; index < key.length(); index++) {
			char[] temp = { hilf.charAt(index), key.charAt(index) };
			liste.add(temp);
		}
	}

	/**
	 * Methode zum �berpr�fen des Schl�ssels. pr�ft: auf ung�ltige Zeichen, ob
	 * Schl�ssel die richtige L�nge hat und ob Buchstaben doppelt vorkommen
	 * 
	 * @param wert
	 * @throws IlligalKeyException
	 */
	public void checkKey(String wert) throws IlligalKeyException {
		if (wert.length() != 26) {
			throw new IlligalKeyException();
		}
		for (int index = 0; index < wert.length(); index++) {
			if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains("" + wert.charAt(index))) {
				throw new IlligalKeyException();
			}
		}
	}

	/**
	 * Methode zum �berpr�fen der message auf falsche zeichen
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
	 * Verschl�sselt den gegebenen Text mit dem angegebenen Schl�ssel.
	 * 
	 * @param message
	 *            Nachricht, die Verschl�sselt werden soll.
	 * 
	 * @return verschl�sselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschl�sselung
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

		String erg = "";
		char[] temp;
		Iterable iterable = liste;
		boolean notFound;

		for (int index = 0; index < message.length(); index++) {
			Iterator iterator = iterable.iterator();
			notFound = true;
			do {
				temp = (char[]) iterator.next();
				if (temp[0] == message.charAt(index)) {
					erg = erg + temp[1];
					notFound = false;
				}
			} while (iterator.hasNext() && notFound);
		}
		return erg;
	}

	/**
	 * Entschl�sselt den gegebenen Text mit dem angegebenen Schl�ssel.
	 * 
	 * @param cypterText
	 *            Nachricht, die entschl�sselt werden soll.
	 * 
	 * @return entschl�sselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschl�sselung
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

		String erg = "";
		char[] temp;
		Iterable iterable = liste;
		boolean notFound;

		for (int index = 0; index < cypherText.length(); index++) {
			Iterator iterator = iterable.iterator();
			notFound = true;
			do {
				temp = (char[]) iterator.next();
				if (temp[1] == cypherText.charAt(index)) {
					erg = erg + temp[0];
					notFound = false;
				}
			} while (iterator.hasNext() && notFound);
		}
		return erg;
	}

}
