package ws2014.tpe.gruppe_1415349_1410206.uebung4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterException;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter;

public class IterableCrypter implements Iterable<String> {
	private List<String> strings;

	/**
	 * Konstruktor für IterableCryptor
	 * 
	 * @param iterable
	 * @param crypter
	 * @throws CrypterException
	 */
	public IterableCrypter(Iterable<String> iterable, Crypter crypter)
			throws CrypterException {
		strings = new ArrayList<String>();
		for (String s : iterable) {
			strings.add(crypter.encrypt(s));
		}
	}

	/**
	 * Iteratord wird hier erzeugt
	 * 
	 * @return CrypterIterator
	 */
	public Iterator<String> iterator() {
		return new CrypterIterator(strings.toArray(new String[0]));
	}
}
