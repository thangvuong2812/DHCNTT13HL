package tcp.bai2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ResquestProcessing extends Thread{
	Socket channel;
	public ResquestProcessing(Socket s) {
		this.channel = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			OutputStream os = channel.getOutputStream();
			InputStream is = channel.getInputStream();
			while(true) {
				int n = is.read();
				if(n==-1)	break;
				os.write(n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
