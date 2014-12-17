package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterException;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.IlligalKeyException;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter;

/**
 * Abstrakte Klasse um Encrypt(List) und decrypt(List) für alle Crypter gleich
 * zu Implementieren
 *
 */
public abstract class AbstractCrypter implements Crypter {

	public abstract void checkKey(String wert) throws IlligalKeyException;

	public abstract void check(String wert) throws CrypterException;

	public abstract String encrypt(String message) throws CrypterException;

	public abstract String decrypt(String cypherText) throws CrypterException;

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 * 
	 * @param messages
	 *            Nachrichten, die Verschlüsselt werden soll.
	 * 
	 * @return verschluesselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		ArrayList<String> erg = new ArrayList<>();
		Iterable<String> iterable = messages;
		Iterator<String> iterator = iterable.iterator();
		String wert = iterator.next();

		while (iterator.hasNext()) {
			check(iterator.next());

			erg.add(encrypt(iterator.next()));
		}
		return erg;
	}

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 * 
	 * @param messages
	 *            Nachrichten, die Verschlüsselt werden soll.
	 * 
	 * @return verschluesselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	@Override
	public List<String> decrypt(List<String> messages) throws CrypterException {
		ArrayList<String> erg = new ArrayList<>();
		Iterable<String> iterable = messages;
		Iterator<String> iterator = iterable.iterator();
		String wert = iterator.next();

		while (iterator.hasNext()) {
			check(iterator.next());

			erg.add(decrypt(iterator.next()));
		}
		return erg;
	}
}
