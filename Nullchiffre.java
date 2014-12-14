package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Nullchiffre implements Crypter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#encrypt(java.lang.String
	 * )
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		for (int index = 0; index < message.length(); index++) {
			if (message.charAt(index) > 'Z' || message.charAt(index) < 'A') {
				throw new CrypterException(message.charAt(index));
			}
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#encrypt(java.util.List)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		Iterator<String> iterator = messages.iterator();
		String wert = iterator.next();
		while (iterator.hasNext()) {
			for (int index = 0; index < wert.length(); index++) {
				if (wert.charAt(index) > 'Z' || wert.charAt(index) < 'A') {
					throw new CrypterException(wert.charAt(index));
				}
			}
		}
		return messages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#decrypt(java.lang.String
	 * )
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		String erg = encrypt(cypherText);
		return erg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#decrypt(java.util.List)
	 */
	@Override
	public List<String> decrypt(List<String> cyrherTexte)
			throws CrypterException {
		encrypt(cyrherTexte);
		return cyrherTexte;
	}

	public static void main(String[] args) {
		Nullchiffre nul = new Nullchiffre();
		String message = "HZa  11JKv";
		boolean schleifeEnde = false;
		String erg = "";

		while (!schleifeEnde) {
			try {
				erg = nul.decrypt(message);
				schleifeEnde = true;
			} catch (CrypterException ex) {
				message = message.toUpperCase();
				for (int index = 0; index < message.length(); index++) {
					message = message.replaceAll("(?u)[^\\pL]", "");
				}
			}

		}
		System.out.println(message);
		System.out.println(erg);
	}

}
