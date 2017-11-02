
package application;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.itextpdf.kernel.pdf.WriterProperties;

public class UsingAPT
{

	public void run() throws IOException
	{
		// ProcessBuilder pb = new ProcessBuilder("java", "-jar", "apt.jar");
		// pb.directory(new File("TEMP"));
		// Process p = pb.start();
		try
		{
			ProcessBuilder builder = new ProcessBuilder("java -jar apt.jar");
			builder.redirectErrorStream(true);
			Process process = builder.start();
			Scanner scanner = null;


		} catch (IOException e)
		{
			e.fillInStackTrace();
		}
	}

}
