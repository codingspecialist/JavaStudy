package airplane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashEx01 {

	public static void main(String[] args) {
		HashMap<String, String> auth = 
				new HashMap<>();
		
		auth.put("���̵�", "ssarmango");
		auth.put("��й�ȣ", "1234");
		
		System.out.println(auth.keySet());
		
		System.out.println(auth.get("���̵�"));

	}

}
