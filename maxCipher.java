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

public class MaxCipher {
	
	String master = "abcdefghijklmnopqrstuvwxyz1234567890 ";
	String ABC = "abcdefghijklmnopqrstuvwxyz1234567890";

	String MAX = "";
	Cipher genericCipher;
	/*public maxCipher(){
		this("");//if no key is given, we use a blank key
	}*/
	public MaxCipher(String key){
		System.out.println(ABC);
		MAX = MAX+ key;
		int index = ABC.indexOf(key.substring(key.length()-1));
		//remove all letters in key from the master list, ABC
		for(int i = 0; i< key.length(); i++){
			ABC = ABC.replaceAll(key.substring(i,i+1),"");
		}
		while(ABC.equals("") == false){
			index = (index+4)%(ABC.length());
			
			MAX = MAX+ABC.substring(index,index+1);//may be probelmatic with the +1
			ABC = ABC.replaceAll(ABC.substring(index,index+1), "");//remove the letter from here
		}
		MAX = MAX + " "; //blank spaces are preserved in this case
		
		genericCipher = new Cipher(MAX);
	}
	
	public String encrypt(String inString){
		return genericCipher.encrypt(inString);
	}
	public String decrypt(String inString){
		return genericCipher.decrypt(inString);
	}
	public boolean encrypt(BufferedReader inFile, String outFileName) throws IOException{
		//encrypt
		return genericCipher.encrypt(inFile, outFileName);
	}
	public boolean decrypt(BufferedReader inFile, String outFileName)throws IOException{
		return genericCipher.decrypt(inFile, outFileName);
		}

}
