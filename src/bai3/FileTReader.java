package bai3;

import java.io.FileReader;
import java.io.IOException;

public class FileTReader extends Thread {
	String fileName;
	public FileTReader(String fileName) {
		this.fileName = fileName;
	}
	
	void readFile(String file) throws IOException {
		FileReader fr = new FileReader(file);
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        if(i == -1) {
        	System.out.println("\n");
        }
        fr.close();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			readFile(fileName);
			Thread.sleep(2000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
