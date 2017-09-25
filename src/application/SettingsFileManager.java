package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SettingsFileManager {
	public void SaveSettingsFile(File file, String background, String circle, String square, String line){
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(background);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(circle);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(square);
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(line);

		final String stringToFile = stringBuilder.toString();
		Saver(stringToFile, file);

	}

	private void Saver(String content, File file) {
		try {
			FileWriter fileWriter = null;

			fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.close();
		} catch (IOException ex) {
			ex.getLocalizedMessage();
		}

	}

}
