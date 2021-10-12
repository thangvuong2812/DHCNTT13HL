package tcp.bai1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTCP {
	public static void main(String[] args) throws IOException {

		//Tạo socket server, chờ tại cổng '6543'
		ServerSocket welcomeSocket = new ServerSocket(6789);
		System.out.println("Server da duoc tao");

		while(true) {
			//chờ yêu cầu từ client
			Socket connectionSocket = welcomeSocket.accept();

			//Tạo input stream, nối tới Socket
			OutputStream os = connectionSocket.getOutputStream();
			InputStream is = connectionSocket.getInputStream();
			
			int ch = 0;
			while(true) {
				ch = is.read();
				if(ch ==-1)	break;
				System.out.println((char)ch);
				os.write(ch);
			}
		
			connectionSocket.close();
		}
	}
}
