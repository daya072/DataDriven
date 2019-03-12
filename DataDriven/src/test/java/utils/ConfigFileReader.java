package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String configFilePath = System.getProperty("user.dir") + "//config//Configuration.properties";
	
	public ConfigFileReader() {
		 BufferedReader reader;
		 try {
			reader = new BufferedReader(new FileReader(configFilePath));
			properties = new Properties();
			
			try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	
	public String GetBrowserName() {
		return properties.getProperty("browser");
	}
	
}
