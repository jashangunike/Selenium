package propFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropfile {

	// public static String Filepath =
	// "X:\\Testing\\Workspace\\Selenium__dkr\\src\\propFile\\config.properties";
	public static String Filepath = System.getProperty("user.dir") + "/src/propFile/config.properties";
	public static Properties prop;
	public static InputStream input;

	public static void main(String[] args) throws IOException {

		prop = new Properties();
		input = new FileInputStream(Filepath);
		prop.load(input);

		// to get the values from properties file

		System.out.println(prop.get("FirstName"));

		String lastname = prop.getProperty("Last_name");
		System.out.println(lastname);

	}

}
