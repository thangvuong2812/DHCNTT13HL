package bai5.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.Finishings;
import javax.rmi.CORBA.Tie;

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
	
	public static String handleString(String s) {
		String result;
		switch (s) {
		case "1":
			result = time()+ "\n" + menu();
			break;
		case "2":
			result = date()+ "\n" + menu();
			break;
		case "3":
			result = date() + " " + time() + "\n" + menu();
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

	public static String time() {
		String pattern = " HH:mm:ss a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		return time;
	}
	
	public static String date() {
		String pattern = "E dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
	
	
	public static String menu() {
		return ">>>>>>>>>>>>> Server response <<<<<<<<<<<<<<<< \n"+
		"1. Time\n"+
		"2. Date\n"+
		"3. Date & Time\n";
	}

}
