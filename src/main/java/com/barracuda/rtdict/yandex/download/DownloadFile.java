package com.barracuda.rtdict.yandex.download;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author artur
 */
public class DownloadFile {

  public static void main(String[] args) throws IOException {
		 
		 String fileName = "file.txt"; //The file that will be saved on your computer
		 URL link = new URL("http://shayconcepts.com"); //The file that you want to download
		
     //Code to download
		 InputStream in = new BufferedInputStream(link.openStream());
                 //in.skip(n);
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 byte[] buf = new byte[1024];
		 int n = 0;
		 while (-1!=(n=in.read(buf)))
		 {
		    out.write(buf, 0, n);
		 }
		 out.close();
		 in.close();
		 byte[] response = out.toByteArray();
 
		 FileOutputStream fos = new FileOutputStream(fileName);
		 fos.write(response);
		 fos.close();
     //End download code
		 
		 System.out.println("Finished");

	}

}
