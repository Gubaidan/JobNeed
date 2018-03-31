package Socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static int port = 8080;
	public static int port = 8080;
	public static String address = "172.0.0.1";

	public static void main(String[] args) {
		while (true) {
			Socket socket = null;
			try {
				socket = new Socket(address,port);
				InputStream inputStream = socket.getInputStream();
				
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter printWriter = new PrintWriter(outputStream);
				printWriter.print(new InputStreamReader(System.in).read());
				printWriter.flush();
				
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String tempString ;
				while ((tempString = bufferedReader.readLine())!=null) {
					System.out.println(tempString);	
					if("OK".equals(tempString)){
						Thread.sleep(500);
						break;
					}
				}
	
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

	}

}
