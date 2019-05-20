package textDataRead;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {

		File obj = new File("D:/dinesh");
		// To Create Folder
		obj.mkdir();

		// to delete the file 
		obj.delete();

		// check file exists or not 
		boolean a = obj.exists();
		if (a == true) {
			System.out.println("File is Exists");
		} else {
			System.out.println("File does not exists");
		}

		// To create a new text file 
		//if u want to create doc file just add extention in last like .doc or .xlsx etc

		File obj2 = new File("D:/textfile.txt");
		try {
			obj2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// for deleting the file or folder same command
		//obj.delete();

	}

}
