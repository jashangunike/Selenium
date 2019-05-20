package textDataRead;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData_TextFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileWriter fw = new FileWriter("D:/textfile.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String data = "hi dinesh";
		bw.write(data);
		bw.close();
		fw.close();

	}

}
