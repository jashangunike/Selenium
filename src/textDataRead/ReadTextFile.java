package textDataRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

	public static void main(String[] args) throws IOException {
		// TO read the text file
		
		String line;
		FileReader file = new FileReader ("D:/textfile.txt");
		BufferedReader br = new BufferedReader(file);
		
		while ((line = br.readLine()) !=null){
			System.out.println(line);
		}
		br.close();	
		file.close();
	}
		
		
}
