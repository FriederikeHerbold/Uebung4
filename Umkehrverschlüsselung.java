package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Umkehrverschl�sselung extends AbstractCrypter {
	/**
	 * Methode zum �berpr�fen des Schl�ssels auf falsche zeichen
	 * 
	 * @param wert
	 * @throws IlligalKeyException
	 */
	@Override
	public void checkKey(String wert) throws IlligalKeyException {
		if (!wert.isEmpty()) {
			throw new IlligalKeyException();
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
		String erg = "";
		try{
			check(message);
		}
		catch(CrypterException ex){
			message = message.replaceAll("(?u)[^\\pL]", "");
		}
		for (int index = message.length() - 1; index >= 0; index--) {
			erg += message.charAt(index);
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
		String erg = encrypt(cypherText);
		return erg;
	}
	

}
