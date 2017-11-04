
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

			 ProcessBuilder pb = new ProcessBuilder("java", "-jar", "apt/apt.jar", "bounded", "apt/nets/eb-nets/basic/pn3-net.apt");

			 Process p = pb.start();
			 BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			 byte[] contents = new byte[1024];

			 int bytesRead = 0;
			 String strFileContents = "";
			 while((bytesRead = in.read(contents)) != -1) {
			     strFileContents += new String(contents, 0, bytesRead);
			 }

			 System.out.print(strFileContents);

	}
	

}
