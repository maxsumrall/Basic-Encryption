import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*
 *This is an implementation of a  maxCipher.
 *I got the idea from the book. Here's how it works:
 *
 *Given a key, the key is placed at the beginning of the new cipher
 *then, every 4th letter not already in the cipher is added to the cipher. (duplicated letters in key are removed)
 *Example:
 *abcdefghijklmnopqrstuvwxyz     KEY = jesus
 *jesuyd...
 *
 *
 *Jonathan Sumrall
 *1DV200
 *LNU-Spring 2012
 * 
*/

public class maxCipher {
	
	String ABC = "abcdefghijklmnopqrstuvwxyz1234567890";
	String MAX = "";
	
	public maxCipher(){
		this("");//if no key is given, we use a blank key
	}
	public maxCipher(String key){
		MAX = MAX+ key;
		//remove all letters in key from the master list, ABC
		for(int i = 0; i< key.length(); i++){
			ABC = ABC.replaceAll(key.substring(i,i+1),"");
		}
		
	}

}
