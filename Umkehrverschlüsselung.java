package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Umkehrverschlüsselung extends AbstractCrypter {
	/**
	 * Methode zum überprüfen des Schlüssels auf falsche zeichen
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
		String erg = encrypt(cypherText);
		return erg;
	}
	

}
