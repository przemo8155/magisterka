
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

			 ProcessBuilder pb = new ProcessBuilder("java", "-jar", "/MagisterkaBudzich/apt/apt.jar");
			 Process p = pb.start();
			 System.out.println(p.isAlive());



	}

}
