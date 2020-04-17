package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
	
	public MySocketServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(15000); // ���� ���� ���� (������ �޴�)
			Socket socket = serverSocket.accept(); // ��û�� ���
			
			System.out.println("��û�� ����");
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String msg = "";
			while((msg = br.readLine()) != null) {
				System.out.println("���� : "+msg);
			}
			
			br.close();
			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MySocketServer();
	}

}
