package udpGK;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UDPServer extends Thread{
	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("Server started...");
		while(true) {
			
			byte[] receiveData = new byte[1024];

			byte[] sendData = new byte[2048];			
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			serverSocket.receive(receivePacket);

			String sentence = new String(receivePacket.getData());

			InetAddress IPAddress = receivePacket.getAddress();

			int port = receivePacket.getPort();

			String sentence_to_client = handleString(sentence.trim());

			sendData = sentence_to_client.getBytes();
			DatagramPacket senPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			serverSocket.send(senPacket);
		}
	}
	public static String readFile(String s) {
		String path = "D:\\IT\\"+s;
		String data= "";
        try {
            File file = new File(path);
            Scanner myReader;
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return data;
	}
	
	public static String upperCaseFile(String s1, String s) {
//		String path1 = "D:\\IT\\"+s1;
		String newString="";
		newString = readFile(s1).replace(s, s.toUpperCase());
		return newString;
	}
	public static String handleString(String s) {
		String[] newS = s.split(" ");
		String result;
		switch (newS[0]) {
		case "1":
	
			result = readFile(newS[1]) +"\n" + menu();
			break;
		case "2":
			result = upperCaseFile(newS[1], newS[2])+ "\n" + menu();
			break;
		case "quit":
			result = "Good bye...";
			break;
		default:
			result = menu();
			break;
		}
		return result;
	}
	
	
	
	public static String menu() {
		return ">>>>>>>>>>>>> Server response <<<<<<<<<<<<<<<< \n"+
		"1. Doc file: (1 file_name)\n"+
		"2. In hoa tu trong file:(2 file_name tu_can_in_hoa)\n";
	}

}
