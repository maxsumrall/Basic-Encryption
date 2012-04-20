import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Transposition{
	
	public Transposition(){
	System.out.print("");
	}
	/**
	 * Reads the entire contents of the inFile, builds the columnar matrix, and writes the transposed message to outFile.
	 * The key is the number of columns to use in the matrix.
	 * @param inFile file to transpose
	 * @param outFile where to write the transposed message
	 * @param key the number of columns to use in the matrix
	 * @return true if operation succeeded successfully
	 */
	public boolean encodeColumnarTransposition(BufferedReader inFile, BufferedWriter outFile, int key) throws IOException{
		LinkedList<LinkedList<String>> masterList = new LinkedList<LinkedList<String>>();
		for(int i = 0; i<key; i++){
			masterList.add(new LinkedList<String>());//masterlist is a list, and each index in the list is another list representing a column
		}
		//So now we have all the columns, we just need to put everything into them.
		char strRep = " ".charAt(0);
		int currColumn = 0;
	    String text = new Scanner( inFile ).useDelimiter("\\A").next();//read the whole file in 1 line :-)
	    text = text.replaceAll("\n", "");
	    text = text.replaceAll(" ", "");
		for(char c: text.toCharArray()){
			strRep = c;//converts the int inChar to its String version, because I like strings and it fits my mental model
			if(!String.valueOf(strRep).equals(" ")){//only if its not a space, AKA we ignore spaces
				masterList.get(currColumn).add(String.valueOf(strRep));
				currColumn++;
				if(currColumn == key){
					currColumn = 0;//loop back around
					
				}
				
			}
		}
		//now pad the matrix so each column is the same length.
		for(int i = 1;i<masterList.size();i++){
			if(masterList.get(i).size() != masterList.get(0).size()){//only possible to have it 1 off
				masterList.get(i).add("X");
			}
		}
		//Now the matrix is filled with the letters
		prettyPrint(masterList);
		//Next is to write out each column to the file.
		for(int i = 0; i < masterList.size();i++){
			for(int j = 0; j < masterList.get(i).size(); j++){try{
				outFile.write(masterList.get(i).get(j));
				System.out.print(masterList.get(i).get(j));
				if(j%masterList.size()==0){System.out.print(" ");}
			}catch(Exception e){}
			}
		}
			
		
		inFile.close();
		outFile.close();
		return true;
		
	}
	
	public void prettyPrint(LinkedList<LinkedList<String>> list){
		System.out.println();
		for(int i = 0; i< list.get(0).size(); i++){
			for(int j = 0;j <list.size();j++){try{
				System.out.print(list.get(j).get(i));
				System.out.print(" ");}catch(Exception e){}
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * Reads in an encoded file and decodes it
	 * @param inFile
	 * @param outFile
	 * @param key
	 * @return true if completed successfully 
	 */
	public boolean decodeColumnarTransposition(BufferedReader inFile, BufferedWriter outFile, int key) throws IOException{
	    String text = new Scanner( inFile ).useDelimiter("\\A").next();//read the whole file in 1 line :-)
		int colLength = (text.length()+1)/key;//integer division on purpose...
		System.out.println(key);
		for(int i = 0; i< colLength; i++){
			for(int j = i; j < text.length(); j+=colLength){
					outFile.write(text.substring(j,j+1));
			}
		}
		inFile.close();
		outFile.close();
		return true;
	}
	
	
	
	
	
	
	
	public String trans(String ktxt, String ptxt){
        int key_length = ktxt.length();
        char[] temp = ktxt.toCharArray();               
                //remove \n from key length
                key_length = key_length - 2;
                int[] key = new int[key_length];
               
                for(int i=0; i < (key_length); i++){
                        key[i] = Character.getNumericValue(temp[i]);
                }              
                               
                char[] temp_in = new char[key_length];
                char[] temp_out = new char[key_length];
                StringBuffer output = new StringBuffer(ptxt.length());
                int max = ptxt.length();
                for(int i = 0; i < max; i+=key_length){
                       
                        //grab chars
                        temp_in = ptxt.substring(i, i+key_length).toCharArray();
                        temp_out = new char[key_length];
                       
                        System.out.println("PLACEHOLDER!" + max);
                        for(int b=0; b<key_length; b++)
                                System.out.print(temp_in[b]);
                       
                        //swap chars
                        for(int j=0; j < key_length; j++){
                                System.out.println(j + " " + key_length);
                                temp_out[j] = temp_in[key[j]-1];
                                System.out.println(temp_out[j] + ":" + temp_in[key[j]-1]);
                        }
                       
                        //add to the output
                        output.append(temp_out);
                        System.out.println(output.toString());
                }
               
                return output.toString();
               
    }

}
