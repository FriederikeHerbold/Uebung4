package ws2014.tpe.gruppe_1415349_1410206.uebung4;

/**
 * Grundlegendes Interface, un Verschlüsselung durchzuführen. Mit Hilfe dieses
 * Interfaces kann man Nachrichten verschlüsseln (über die
 * {@link #encrypt(String)} Methode) und wieder entschlüsseln (über die
 * {@link #decrypt(String)} Methode).
 *
 * Der Eingabetext ({@literal massage}) darf nur aus den Groß-Buchstaben A-Z
 * bestehen. Kleinbuchstaben werden in Großbuchstaben umgewandelt, alle anderen
 * Zeichen werden ohne Rückmeldung entfernt(einschließlich Leerzeichen).
 *
 * Zwischen den beiden Methoden muss bei gleichem Schlüssel {@code key}
 * folgendes gelten: {@code text.equals(decrypt(encrypt(text))==true}
 * 
 * @author Thomas Smits
 */
public interface Crypter {

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
	public String encrypt(String message) throws CrypterException;

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
	public List<String> encrypt (List<String> messages)
			throws CrypterException;
	
	/**
	 * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
	 * 
	 * @param cypterText Nachricht, die entschlüsselt werden soll.
	 * 
	 * @return entschlüsselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	
	publis String decrypt(String cypherText)
			throws CrypterException;
	
	/**
	 * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
	 * 
	 * @param cypterTexte Nachricht, die entschlüsselt werden soll.
	 * 
	 * @return entschlüsselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */
	publis List<String> decrypt(List<String> cyrherTexte)
			throws CrypterException;
}

