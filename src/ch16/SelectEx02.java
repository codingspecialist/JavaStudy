package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SelectEx02 {
	
	public static void main(String[] args) {
		try {
			final String SQL = "select id, name, email, password from users";
			// OJDBC ������ �ش� ����̹��� �ε��ض�� �Ŵ����� ����.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ssar", "bitc5600");
			// ���� �ޱ� (?�� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			// ���ۿ� ���� (ResultSet�� ���Ϲ���)
			ResultSet rs = pstmt.executeQuery();
			List<Users> users = new ArrayList<>(); 
			
			while(rs.next()) {
				Users user = new Users(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("password")
				);
				users.add(user);
			}
			
			for (Users user: users) {
				System.out.println(user.getId());
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println();
			}

			System.out.println("����Ʈ �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
