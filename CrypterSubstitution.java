package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrypterSubstitution implements Crypter {
	List liste=new ArrayList();

	public CrypterSubstitution(String key) throws IlligalKeyException{
		checkKey(key);
		String hilf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int index = 0; index < key.length(); index++) {
			char[] temp = { hilf.charAt(index), key.charAt(index) };
			liste.add(temp);
		}
	}

	/**
	 * 
	 * @param wert
	 * @throws IlligalKeyException
	 */
	private void checkKey(String wert) throws IlligalKeyException {
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
	 * 
	 * @param wert
	 * @throws CrypterException
	 */
	private void check(String wert) throws CrypterException {
		for (int index = 0; index < wert.length(); index++) {
			if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains("" + wert.charAt(index))) {
				throw new CrypterException();
			}
		}
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		check(message);

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

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		check(cypherText);

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
		CrypterSubstitution nul = null;
		try {
			nul = new CrypterSubstitution("UFLPWDRASJMCONQYBVTEXHZKGI");
		} catch (IlligalKeyException ex) {
			System.out.println("falscher Schlüssel\n");
		}
		String message = "WIKIPEDIAISTINVORMATIV";

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
