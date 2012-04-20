
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {

		public static void main(String[] args) throws Exception{
			Transposition t = new Transposition();
			BufferedReader reader = new BufferedReader(new FileReader("bookExample"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("tran"));
			t.encodeColumnarTransposition(reader, writer, 5);
			reader = new BufferedReader(new FileReader("tran"));
			writer = new BufferedWriter(new FileWriter("detran"));
			t.decodeColumnarTransposition(reader, writer, 5);
			
		}
}
