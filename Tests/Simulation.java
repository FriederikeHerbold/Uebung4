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

public class Simulation {
	public static void main(String[] args) throws IlligalKeyException,
			CrypterException {
		Crypter reverse = CrypterFactory
				.createCrypter(Verschluesselung.REVERSE);
		Crypter caesar = CrypterFactory.createCrypter("L",
				Verschluesselung.CAESAR);
		Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS",
				Verschluesselung.XOR);
		Crypter subst = CrypterFactory.createCrypter(
				"MNBVCXYLKJHGFDSAPOIUZTREWQ", Verschluesselung.SUBSTITUTION);

		String message = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";
		System.out.println(message);
		String erg;
		erg = xor.decrypt(message);
		System.out.println(erg);
		erg = reverse.decrypt(erg);
		System.out.println(erg);
		erg = caesar.decrypt(erg);
		System.out.println(erg);
		erg = subst.decrypt(erg);
		System.out.println(erg);
		erg = erg.replaceAll("X", " ");
		System.out.println(erg);
	}
}
