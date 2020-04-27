package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateEx01 {

	public static void main(String[] args) {
		try {
			final String SQL = "update users set password = ? where id = ?";
			// OJDBC ������ �ش� ����̹��� �ε��ض�� �Ŵ����� ����.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ssar", "bitc5600");
			// ���� �ޱ� (?�� ����ϰ� ���ش�)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "5678");
			pstmt.setInt(2, 2);
			// ���ۿ� ���� (commit)
			pstmt.executeUpdate();
			System.out.println("������Ʈ �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
