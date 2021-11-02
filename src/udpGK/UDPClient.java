package udpGK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UDPClient extends Thread{
	
	public static void main(String[] args) throws IOException {
		System.out.println("nhap port: ");
		Scanner sc = new Scanner(System.in);
		DatagramSocket clientSocket = new DatagramSocket(sc.nextInt());
		InetAddress IPAddress = InetAddress.getByName("localhost");
		while(true) {
			byte[] sendData = new byte[1024];
			
			byte[] receiveData = new byte[2048];
			
			BufferedReader infromUser = new BufferedReader(new InputStreamReader(System.in));
			
			String sentence = infromUser.readLine();
			
			sendData = sentence.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			
			clientSocket.send(sendPacket);
			
			
			//goi tin nhan co keiu byte
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			
			String modified_sentence = new String(receivePacket.getData());
			System.out.println("FROM SERVER: " + modified_sentence);
			
			if (sentence.compareTo("quit") == 0) {
				break;
			}
		}
		clientSocket.close();
	}
}
