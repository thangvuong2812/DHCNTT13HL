package thuchanh.bai1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTCP {
	public static void main(String[] args) throws IOException {
		String sentence_from_client;
		String sentence_to_client;
		//Tạo socket server, chờ tại cổng
		ServerSocket welcomeSocket = new ServerSocket(6789);
		System.out.println("Server da duoc tao");

		while(true) {
			//chờ yêu cầu từ client
			Socket connectionSocket = welcomeSocket.accept();

			//Tạo input stream, nối tới Socket
			OutputStream os = connectionSocket.getOutputStream();
			InputStream is = connectionSocket.getInputStream();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(is));
			
			DataOutputStream outToClient = new DataOutputStream(os);
			
			
			sentence_from_client = inFromClient.readLine();
			
			sentence_to_client = handleRead(Integer.valueOf(sentence_from_client)) +"\n";
			
			outToClient.writeBytes(sentence_to_client);		}
	}

	public static String handleRead(int n) {
		String result="";
		switch (n) {
		case 0:
			result = "Khong";
			break;
		case 1:
			result = "Mot";
			break;
		case 2:
			result = "Hai";
			break;
		case 3:
			result = "Ba";
			break;
		case 4:
			result = "Bon";
			break;
		case 5:
			result = "Nam";
			break;
		case 6:
			result = "Sau";
			break;
		case 7:
			result = "Bay";
			break;
		case 8:
			result = "Tam";
			break;
		case 9:
			result = "Chin";
			break;
		default:
			break;
		}
		return result;
	}
}
