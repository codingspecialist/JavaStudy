package ch16;

class MyManager {
	
	private static Animal animal;
	
	public static void register() {
		animal = new Animal();
	}
	
	public static Animal getConnection() {
		return animal;
	}
}

class Animal {
	public Animal() {
		System.out.println("Animal ������");
	}
	// new�Ҷ� 
	static {
		// (1) Animal ��ü ���� 
		MyManager.register();
		// (2) MyManagerŬ������ Animal ��ü�� ���� �ּҸ� ����
	}
}

public class Hello {
	public static void main(String[] args) {
		try {
			Class.forName("ch16.Animal");
			Animal a = MyManager.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
