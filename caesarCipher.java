import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*
 *This is an implementation of a Caesar Cipher. Pretty simple...
 *
 *Jonathan Sumrall
 *1DV200
 *LNU-Spring 2012
 * 
*/

public class CaesarCipher{
	/**
	 * Given a String, returns an encrypted version of the string. 
	 * Implemeted accord to the textbook, where there is a shift by 3 down the alpahbet. 
	 * Example: abc -> def
	 * @param String what to encrypt
	 * @return Encrypted String
	 */
	String DEF = "defghijklmnopqrstuvwxyzabc4567890123 ";
	Cipher genericCipher;
	public CaesarCipher(){
		genericCipher = new Cipher(DEF);
	}
	public String encrypt(String inString){
		return genericCipher.encrypt(inString);	
	}
	public String decrypt(String inString){
		return genericCipher.decrypt(inString);
	}
	public boolean encrypt(BufferedReader inFile, String outFileName) throws IOException{
		return genericCipher.encrypt(inFile, outFileName);
	}
	public boolean decrypt(BufferedReader inFile, String outFileName)throws IOException{
		return genericCipher.decrypt(inFile, outFileName);
		}
	}