package bai3;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		String path = "D:\\\\IT\\\\eclipse-workspace\\\\PTHTTH.Tuan3\\\\bai3-1.txt";
		FileTWrite fw1 = new FileTWrite(path, "File text 1 cua bai 3 123123123123123123123123");
		
		FileTReader fr1 = new FileTReader(path);
		
		fw1.start();
		fw1.join();
		fr1.start();
		
	}
}
