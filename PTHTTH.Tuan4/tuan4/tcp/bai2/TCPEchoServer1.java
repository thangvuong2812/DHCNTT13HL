package tcp.bai2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer1 {
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(9876);
			System.out.println("Server da duoc tao");
			while(true) {
				Socket s = ss.accept();
				
				ResquestProcessing rp = new ResquestProcessing(s);
				rp.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
