package bai3;

import java.io.FileWriter;


public class FileTWrite extends Thread{
	String nameFile;
	String contentFile;
	public FileTWrite(String nameFile, String contentFile) {
		this.nameFile = nameFile;
		this.contentFile = contentFile;
	}

	public void writeIntFile (String file, String content) {
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.write(content);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success writing...");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		writeIntFile(this.nameFile, this.contentFile);
	}
}
