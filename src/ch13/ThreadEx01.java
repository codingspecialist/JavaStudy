package ch13;

// OS��  Runnable Ÿ���� heap������ run�޼��带 ȣ���ؾߵȴٴ� �� �̹� �˰� ����.
class Sub implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("���� ������ : "+i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx01 {

	// ���� ������
	public static void main(String[] args) {
		Sub s = new Sub();
		Thread t1 = new Thread(s);
		t1.start();
		
		for (int i = 1; i < 6; i++) {
			System.out.println("���� ������ : " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
