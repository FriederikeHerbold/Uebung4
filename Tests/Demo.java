package ws2014.tpe.gruppe_1415349_1410206.uebung4.Tests;

import java.util.Arrays;
import java.util.List;

import ws2014.tpe.gruppe_1415349_1410206.uebung4.Crypter;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterException;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterFactory;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterFactory.Verschluesselung;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.IlligalKeyException;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.IterableCrypter;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.IterableDecrypter;

public class Demo {

	public static void main(String[] args) throws IlligalKeyException,
			CrypterException {
		Crypter caesar = CrypterFactory.createCrypter("U",
				Verschluesselung.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL",
				Verschluesselung.XOR);

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

		IterableCrypter iterableCrypter = new IterableCrypter(
				new IterableCrypter(liste, caesar), xor);

		for (String cypherText : iterableCrypter) {
			System.out.println(cypherText);
		}
	}
}
