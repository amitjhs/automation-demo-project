package com.metacube.testng.FrameworkHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;

public class Prop {

	public static Properties LoadProperties(String PropertFile) {
		Properties prop = new Properties();
		String path = FileSystems.getDefault()
				.getPath(AppConstants.PropertyFilesPath, PropertFile)
				.toString();
		FileInputStream input = null;
		try {
			input = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// load a properties file
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static String GetProperty(String _propfile, String _property) {
		Properties prop = LoadProperties(_propfile);
		return prop.getProperty(_property).trim();
	}
}
