package bai1;

import java.io.FileWriter;


public class FileTWrite extends Thread{
	String nameFile;
	public FileTWrite(String nameFile) {
		this.nameFile = nameFile;
	}

	public void writeRandomNumber (String file) {
		try {
			FileWriter fw = new FileWriter(file);
			double ranNum = Math.random();
			String s = String.valueOf(ranNum);
			fw.write(s);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		writeRandomNumber(this.nameFile);
	}
}
