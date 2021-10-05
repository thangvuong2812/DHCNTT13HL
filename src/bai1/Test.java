package bai1;

public class Test {
	public static void main(String[] args) {
		FileTWrite fw1 = new FileTWrite("D:\\IT\\eclipse-workspace\\PTHTTH.Tuan3\\file1.txt");
		FileTWrite fw2 = new FileTWrite("D:\\IT\\eclipse-workspace\\PTHTTH.Tuan3\\file2.txt");
		FileTWrite fw3 = new FileTWrite("D:\\IT\\eclipse-workspace\\PTHTTH.Tuan3\\file3.txt");
		
		fw1.start();
		fw2.start();
		fw3.start();
	}
}
