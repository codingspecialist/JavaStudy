package ch16;

class MyConnection {
	
}

class MyJDBC extends MyConnection{
	
	static MyConnection conn;
	
	public MyJDBC() {
		System.out.println("������ ȣ��");
	}
	// new �� �� static ���ΰ� ȣ���.
	static {
		conn = new MyJDBC();
	}
}

class Hi {
	public void play() {
		MyConnection conn = MyJDBC.conn;
	}
}

public class TestEx01 {

	public static void main(String[] args) {
		// MyJDBC mj = new MyJDBC();
		try {
			Class.forName("ch16.MyJDBC");
			MyConnection conn = MyJDBC.conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
