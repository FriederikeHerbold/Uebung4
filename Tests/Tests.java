package ws2014.tpe.gruppe_1415349_1410206.uebung4.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterCarsar;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterSubstitution;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.CrypterXor;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.IlligalKeyException;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.Nullchiffre;
import ws2014.tpe.gruppe_1415349_1410206.uebung4.Umkehrverschlüsselung;

public class Tests {
	try{
	CrypterCarsar caesar = new CrypterCarsar("A");
	CrypterCarsar caesar2 = new CrypterCarsar("Z");
	CrypterXor xor=new CrypterXor("A");
	CrypterXor xor2=new CrypterXor("@");
	CrypterSubstitution subst=new CrypterSubstitution("ABCDEFGHIJKLMNOPQRSTUVWXYZ") ;
	CrypterSubstitution subst2=new CrypterSubstitution("MNBVCXYLKJHGFDSAPOIUZTREWQ");
	Umkehrverschlüsselung rev=new	Umkehrverschlüsselung();		
	Nullchiffre nul=new Nullchiffre();
	}
	catch(IlligalKeyException ex){
		
	}
	@Test
	public void caesarTest(){
		assertEquals("B",caesar.encrypt("A"));
		assertEquals("Z",caesar.encrypt("Y"));
		assertEquals("A",caesar.encrypt("Z"));
		assertEquals("A",caesar2.encrypt("A"));
		assertEquals("A",caesar.decrypt("B"));
		assertEquals("Y",caesar.decrypt("Z"));
		assertEquals("A",caesar.decrypt("Z"));
		assertEquals("A",caesar2.decrypt("A"));
		
	}
	@Test
	public void xorTest(){
		assertEquals("@@@@",xor.encrypt("AAAA"));
		assertEquals("AAAA",xor2.encrypt("AAAA"));
		assertEquals("AAAA",xor.decrypt("@@@@"));
		assertEquals("AAAA",xor2.decrypt("AAAA"));
	}
	@Test
	public void substTest(){
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",subst.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("MNBVCXYLKJHGFDSAPOIUZTREW",subst2.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",subst2.decrypt("MNBVCXYLKJHGFDSAPOIUZTREW"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",subst.decrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}
	@Test
	public void revTest(){
		assertEquals("ZYXWVUTSRQPONMLKJIHGFEDCBA",rev.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ZYXWVUTSRQPONMLKJIHGFEDCBA",rev.decrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}
	@Test
	public void nullTest(){
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",nul.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",nul.decrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}
}
