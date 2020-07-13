package p20200707;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class P0707_4 {
	public static void main(String[] args) {
		boolean append = false;
		int i, len = 0;
		String strFile01 = "C:/Users/user/eclipse-workspace/hello/src/theater/TheaterSystemImpl.java";
		String strFile02 = "C:/Users/user/Desktop/fileStreamTest.txt";
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(new File(strFile01));
			out = new FileOutputStream(strFile02, append);
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
		try {
			while((i=in.read())!=-1) {
				System.out.println(i);
				out.write(i);
				len++;
			}
			in.close(); out.close();
			System.out.println(len + " bytes are copied...");
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
