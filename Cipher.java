import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*
 *This is an implementation of a cipher. The new cipher mapping is passed in as a parameter. 
 *
 *Jonathan Sumrall
 *1DV200
 *LNU-Spring 2012
 * 
*/

public class Cipher{
	/**
	 * Given a String, returns an encrypter version of the string. 
	 * @param String what to encrypt
	 * @return Encrypted String
	 */
	final HashMap<String, String> eMapping;
	final HashMap<String, String> dMapping;
	
	String ABC = "abcdefghijklmnopqrstuvwxyz1234567890 ";// :-) notice the blank space at both end? blank --> blank (I'm so clever)
	
	public Cipher(String substitutedVersion){
		String DEF = substitutedVersion;
		//Build the mapping. Yes, you can do with without the hashmap and just compare the index from ABC and find the new letter in DEF, but I used a hashmap. 
		eMapping = new HashMap<String, String>();
		for(int i = 0; i< ABC.length(); i++){
			eMapping.put(ABC.substring(i,i+1),DEF.substring(i,i+1));
		}
		dMapping = new HashMap<String, String>();
		for(int i = 0; i<DEF.length(); i++){
			dMapping.put(DEF.substring(i,i+1),ABC.substring(i,i+1));
		}
	}
	public String encrypt(String inString){
		//Given a string, return the excrypted version of the string
		inString = inString.toLowerCase();
		String encrypted = "";
		for(int i=0; i < inString.length(); i++){
			encrypted = encrypted + (eMapping.get(inString.substring(i,i+1)));
		}
		return encrypted;
		
	}
	/**
	 * given a String that is encrypted using the encrypt method, a decrypted message is returned. 
	 * @param String to decrypt
	 * @return String the origional message
	 */
	public String decrypt(String inString){
		//decrypt
		inString = inString.toLowerCase();
		String decrypted = "";
		for(int i = 0;i < inString.length(); i++){
			decrypted= decrypted + (dMapping.get(inString.substring(i,i+1)));
		}
		return decrypted;
	}
	/**
	 * given a BufferedReader, reads from the input stream and writes an encrypted version of the file
	 * to a new file of the String passed in as outFileName
	 * @return true if method finished successfully
	 * @param BufferedReader inFile the file to read from
	 * @param String outFileName the name of the file to write the output to. Will overwrite this file!
	 * @throws IOException when the outFile causes a problem
	 */
	public boolean encrypt(BufferedReader inFile, String outFileName) throws IOException{
		//encrypt
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
		String inLine = inFile.readLine();
		while (inLine != null){
			writer.write(encrypt(inLine));
			writer.newLine();
			inLine = inFile.readLine();
		}
		writer.close();
		inFile.close();
		return true;
	}
	/**
	 * given a BufferedReader, reads from the input stream and writes an decrypted version of the file
	 * to a new file of the String passed in as outFileName
	 * @return true if method finished successfully
	 * @param BufferedReader inFile the file to read from
	 * @param String outFileName the name of the file to write the output to. Will overwrite this file!
	 * @throws IOException when the outFile causes a problem
	 */
	public boolean decrypt(BufferedReader inFile, String outFileName)throws IOException{
		//decrypt
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
		String inLine = inFile.readLine();
		while(inLine != null){
			writer.write(decrypt(inLine));
			writer.newLine();
			inLine = inFile.readLine();
		}
		inFile.close();
		writer.close();
		return true;
		}
	}
