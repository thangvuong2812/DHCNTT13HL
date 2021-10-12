package tcp.bai1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClient {
	public static void main(String[] args) throws InterruptedException, IOException {
		Socket s = null;
		
		try {
			s = new Socket("127.0.0.1", 6789);
			System.out.println("Client da duoc tao");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			for (int i = '0'; i <= '9'; i++) {
				os.write(i);
				int ch = is.read();
				System.out.println((char)ch);
				Thread.sleep(2000);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(s != null) {
				s.close();
			}
		}
	}
}
