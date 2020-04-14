package ch13;

interface Callback {
	void printMoney(int money);
}

class MoneyChange {
	int money = 10000;
	
	public void accept(Callback callback) {
		// ���࿡ ���� ��û�� �ؼ� 20000���� ���� ���� 2��!!
		new Thread(new Runnable() {	
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					money = money + 20000;
					callback.printMoney(money);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();		
	}
}

public class ThreadEx03 {
	
	public static void main(String[] args) {
		int myMoney = 500;
		MoneyChange mc = new MoneyChange();
		mc.accept(new Callback() {
			@Override
			public void printMoney(int money) {
				
				System.out.println("������ �ܾ��� : "+money);
				System.out.println("�� �հ�ݾ��� : "+(money+myMoney));
			}
		});
		
		for (int i = 1; i < 6; i++) {
			System.out.println("���ξ����� : "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
