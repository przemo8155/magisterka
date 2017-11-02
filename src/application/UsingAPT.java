package application;
import java.io.IOException;
import java.io.InputStream;

public class UsingAPT
{
	public void run() throws IOException
	{
		// Run a java app in a separate system process
		Process proc = Runtime.getRuntime().exec("java -jar apt.jar");
		// Then retreive the process output
		InputStream in = proc.getInputStream();
		InputStream err = proc.getErrorStream();
		System.out.println(err);
		System.out.println(in);
	}

}
