package swag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	public static String readFile(final String path) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line;
			while ((line = reader.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
}
