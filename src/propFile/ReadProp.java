package propFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Dinesh Reddy
 * 
 *         How to read property: - Only 3 steps are there :
 *         1. we have to create the object of properties class
 *         2. create the object of fileinputstream class
 *         3. Load the prop file
 * 
 *         # property file like - key and value, ex- browser = chrome here, browser is
 *         key, chrome is value.
 *
 */
public class ReadProp {

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/propFile/config.properties");
		prop.load(ip); // here connection are established

		System.out.println(prop.get("FirstName")); // here we are passing the key
													// you will get the value here

		// key value is not mentioned in prop file
		System.out.println("incase you did't mention the key value then, output is :"
				+ prop.getProperty("key value not mentioned in prop value"));

	}
}
