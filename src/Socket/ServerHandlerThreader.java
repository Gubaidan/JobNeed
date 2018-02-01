package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandlerThreader implements Runnable{
	private Socket socket;
	
	public ServerHandlerThreader(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String tempString;
			System.out.println("客户端发来的消息：");		
			while ((tempString = bufferedReader.readLine())!=null) {
				System.out.println(tempString);		
			}
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.print("回复！");
			printWriter.flush();
			socket.shutdownOutput();
			
			inputStream.close();
			inputStreamReader.close();
			bufferedReader.close();
			outputStream.close();
			printWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					socket = null;
					e.printStackTrace();
				}
			}
		}
		
	}
}