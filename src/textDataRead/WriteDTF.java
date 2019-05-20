package textDataRead;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDTF {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader("D:/textfile.txt");
		FileWriter fw = new FileWriter("D:/writing to textfile2.txt");
		
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line;
		
		while ((line=br.readLine()) !=null){
			bw.write(line);
			bw.newLine();
		}
		br.close();
		bw.close();
		fr.close();
		fw.close();
		

	}

}
