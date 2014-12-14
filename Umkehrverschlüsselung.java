package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Umkehrverschlüsselung implements Crypter {
	

	/* (non-Javadoc)
	 * @see ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		String erg = "";
		for (int index = 0; index < message.length(); index++) {
			if (message.charAt(index) > 'Z' || message.charAt(index) < 'A') {
				throw new CrypterException(message.charAt(index));
			}
		}
		for(int index = message.length()-1; index >= 0; index --){
			erg += message.charAt(index);
		}
		return erg;
	}

	/* (non-Javadoc)
	 * @see ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#encrypt(java.util.List)
	 */
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

	/* (non-Javadoc)
	 * @see ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		String erg = encrypt(cypherText);
		return erg;
	}

	/* (non-Javadoc)
	 * @see ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter#decrypt(java.util.List)
	 */
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
		Umkehrverschlüsselung umk = new Umkehrverschlüsselung();
		String message = "ZU hzRT..";
		boolean schleifeEnde = false;
		String aa = "";

		while (!schleifeEnde) {
			try {
				aa = umk.decrypt(message);
				schleifeEnde = true;
			} catch (CrypterException ex) {
				message = message.toUpperCase();
				for (int index = 0; index < message.length(); index++) {
					message = message.replaceAll("(?u)[^\\pL]", "");
				}
			}

		}
		System.out.println(message);
		System.out.println(aa);

	/*	ArrayList<String> list = new ArrayList<>();
		list.add("Eintrag 1");
		
		ArrayList<String> list1 = new ArrayList<>();
		while (!schleifeEnde) {
			try {
				list1 = list1.encrypt(list);
				schleifeEnde = true;
			} catch (CrypterException ex) {
				message = message.toUpperCase();
				for (int index = 0; index < message.length(); index++) {
					message = message.replaceAll("(?u)[^\\pL]", "");
				}
			}

		}
		System.out.println(message);
		System.out.println(aa);
	}*/
	}
}
