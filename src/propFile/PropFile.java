package propFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropFile {

	public static String Filepath = System.getProperty("user.dir") + "/src/propFile/config.properties";
	public static Properties prop;
	public static InputStream input;

	public static String fetchProp(String Key) {

		try {
			prop = new Properties();
			input = new FileInputStream(Filepath);
			prop.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String value = prop.getProperty(Key);
		return value;

	}

	public static void main(String[] args) {

		// Calling by using object
		PropFile obj = new PropFile();
		obj.fetchProp("key");
		System.out.println("By using object :" + obj.fetchProp("key"));

		// Calling by using class name 
		PropFile.fetchProp("key");
		System.out.println("Calling propfile by using classname this is correct way & the key value is :"
				+ PropFile.fetchProp("key"));

		//System.out.println("prop key value is :"obj.fetchProp("key"));
	}

}
