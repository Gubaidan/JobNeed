package Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static int port = 8080;

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		System.out.println("服务端已启动，等待客户端连接..");
		Server.init();
	}
	
	public static void init() throws IOException{
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true){
				Socket socket = serverSocket.accept();
				new ServerHandlerThreader(socket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}


