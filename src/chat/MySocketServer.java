package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// CTRL + SHIFT + O
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MySocketServer {
	
	ServerSocket serverSocket;
	Vector<NewSocketThread> vt;
	
	public MySocketServer(){
		vt = new Vector<>();
		try {
			serverSocket = new ServerSocket(3000);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("��û�� ����");
				NewSocketThread nt = new NewSocketThread(socket);
				Thread newWorker = new Thread(nt);
				newWorker.start();
				vt.add(nt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// ���ο� �����忡�� ���۸� ������ �� �ְ� socket�� ����!!
	class NewSocketThread implements Runnable {
		
		Socket socket;
		BufferedReader br;
		BufferedWriter bw;
		
		public NewSocketThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				br = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = 
				new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				String msg = "";
				while((msg = br.readLine()) != null) {
					System.out.println("Ŭ���̾�Ʈ : "+msg);
					for (NewSocketThread newSocketThread : vt) {
						if(newSocketThread != this) {
							newSocketThread.bw.write(msg+"\n");
							newSocketThread.bw.flush();
							
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new MySocketServer();
	}
}
