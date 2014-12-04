package ws2014.tpe.gruppe_1415349_1410206.uebung4;

/**
 * Grundlegendes Interface, un Verschl�sselung durchzuf�hren. Mit Hilfe dieses
 * Interfaces kann man Nachrichten verschl�sseln (�ber die
 * {@link #encrypt(String)} Methode) und wieder entschl�sseln (�ber die
 * {@link #decrypt(String)} Methode).
 *
 * Der Eingabetext ({@literal massage}) darf nur aus den Gro�-Buchstaben A-Z
 * bestehen. Kleinbuchstaben werden in Gro�buchstaben umgewandelt, alle anderen
 * Zeichen werden ohne R�ckmeldung entfernt(einschlie�lich Leerzeichen).
 *
 * Zwischen den beiden Methoden muss bei gleichem Schl�ssel {@code key}
 * folgendes gelten: {@code text.equals(decrypt(encrypt(text))==true}
 * 
 * @author Thomas Smits
 */
public interface Crypter {

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
	public String encrypt(String message) throws CrypterException;

	/**
	 * Verschluesselt den gegebenen Text mit dem angegebenen Schluessel.
	 * 
	 * @param messages
	 *            Nachrichten, die Verschl�sselt werden soll.
	 * 
	 * @return verschluesselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschl�sselung
	 *             auftreten.
	 */
	public List<String> encrypt (List<String> messages)
			throws CrypterException;
	
	/**
	 * Entschl�sselt den gegebenen Text mit dem angegebenen Schl�ssel.
	 * 
	 * @param cypterText Nachricht, die entschl�sselt werden soll.
	 * 
	 * @return entschl�sselter Text.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschl�sselung
	 *             auftreten.
	 */
	
	publis String decrypt(String cypherText)
			throws CrypterException;
	
	/**
	 * Entschl�sselt den gegebenen Text mit dem angegebenen Schl�ssel.
	 * 
	 * @param cypterTexte Nachricht, die entschl�sselt werden soll.
	 * 
	 * @return entschl�sselte Texte.
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschl�sselung
	 *             auftreten.
	 */
	publis List<String> decrypt(List<String> cyrherTexte)
			throws CrypterException;
}

