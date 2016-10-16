package ex;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;


public class s {

	public static void main(String[] args) {
		int buffer_size = 4096;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter URL here : ");
		String urlpath=scan.nextLine(); 
		URL url = null;
	
		try {

		        //connection to the remote object referred to by the URL.
		        url = new URL(urlpath);
		        // connection to the Server
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		        // get the input stream from conn
		        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
		        
		        //get name of the file from url
		        String fn = url.getFile().toString();
				String filename=  fn.substring( fn.lastIndexOf('/')+1, fn.length() );
				System.out.println(fn);
				System.out.println(filename);
				
		        // save the contents to a file
		        RandomAccessFile raf = new RandomAccessFile(filename,"rw");


		        byte[] buf = new byte[ buffer_size ];
		        int read;

		        while ((read = in.read(buf, 0, buffer_size)) != -1)
		        {
		            raf.write(buf, 0, read);
		        }

		    } catch ( IOException e ) {

		    }
		    finally {

		    }
		System.out.println("Done !");
		//get file name from url
		String fn = url.getFile().toString();
		String filename=  fn.substring( fn.lastIndexOf('/')+1, fn.length() );
		System.out.println(fn);
		System.out.print(filename);
	}

}
