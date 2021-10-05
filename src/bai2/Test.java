package bai2;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FileTReader fr1 = new FileTReader("D:\\IT\\eclipse-workspace\\PTHTTH.Tuan3\\file1.txt");
		FileTReader fr2 = new FileTReader("D:\\IT\\eclipse-workspace\\PTHTTH.Tuan3\\file2.txt");
		FileTReader fr3 = new FileTReader("D:\\IT\\eclipse-workspace\\PTHTTH.Tuan3\\file3.txt");
		
		
		fr1.start();
		fr1.join();
		fr2.start();
		fr2.join();
		fr3.start();
		fr3.join();
	}

}
